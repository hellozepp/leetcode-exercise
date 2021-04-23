package suanfa.interview.myelevator;

import lombok.Builder;
import lombok.Data;
import org.Thread.stop.thread;
import org.apache.commons.lang.math.RandomUtils;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: zhanglin
 * @Date: 2019/6/29
 * @Time: 2:45 PM
 */
public class MyElevatorScheduler {
    enum RunningStat {
        INIT, UP, DOWN
    }

    static class DistFloor {
        int i;

        public DistFloor(int i) {
            this.i = i;
        }

        void clickAFloorButton(Elevator e) {
            e.btnMap.putIfAbsent(i, null);
        }
    }

    @Data
    @Builder
    static class Elevator {
        /**
         * 电梯当前运行状态
         */
        volatile RunningStat stat;
        /**
         * 最高层
         */
        volatile int top = 20;
        /**
         * 最底层
         */
        volatile int bottom = 0;

        volatile int curFloor = 1;

        /**
         * 所有外部按钮
         */
        volatile Map<Integer, DistFloor> btnMap;//修改为队列


    }

    /**
     *
     */
    interface LiftAction {
        /**
         * 电梯升降处理,返回到达楼层
         * 状态处理: 上升/下降
         * @param e
         * @return
         */
        void lift(Elevator e);
    }

    class LiftActionPolicyFactory implements LiftAction {
        ElecatorPolicyFactory factory = new ElecatorPolicyFactory();

        @Override
        public void lift(Elevator e) {
            while (e.btnMap.size() > 0) {
                if (e.stat == RunningStat.DOWN) {
                    Map<Integer, DistFloor> btnMap = e.btnMap;
                    for (Integer integer : btnMap.keySet()) {
                        if (e.curFloor >= integer) {
                            //处理下降
                            try {
                                Thread.sleep(5000 * Math.abs(e.curFloor - integer));
                                e.curFloor = integer;
                                btnMap.remove(integer);
                                DistFloor distFloor = btnMap.get(integer);
                                if (distFloor != null) {
                                    //回调乘客的去往楼层
                                    distFloor.clickAFloorButton(e);
                                }
                                factory.openDoorAction(integer);
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                                break;
                            }
                            break;
                        }
                    }
                } else if (e.stat == RunningStat.UP) {
                    Map<Integer, DistFloor> btnMap = e.btnMap;
                    for (Integer integer : btnMap.keySet()) {
                        if (e.curFloor <= integer) {
                            //处理上升
                            try {
                                Thread.sleep(5000 * Math.abs(e.curFloor - integer));
                                e.curFloor = integer;
                                btnMap.remove(integer);
                                DistFloor distFloor = btnMap.get(integer);
                                if (distFloor != null) {
                                    //回调乘客的去往楼层
                                    distFloor.clickAFloorButton(e);
                                }
                                factory.openDoorAction(integer);
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                                break;
                            }
                            break;
                        }
                    }
                } else {
                    Set<Integer> integers = e.btnMap.keySet();
                    if (integers.size() > 0) {
                        Integer integer = integers.iterator().next();
                        if (e.curFloor < integer) {
                            e.stat = RunningStat.UP;
                        } else if (e.curFloor > integer) {
                            e.stat = RunningStat.DOWN;
                        } else {
                            e.stat = RunningStat.INIT;
                        }
                        DistFloor distFloor = e.btnMap.get(integer);
                        if (distFloor != null) {
                            //回调乘客的去往楼层
                            distFloor.clickAFloorButton(e);
                        }
                        try {
                            Thread.sleep(5000 * (Math.abs(e.curFloor - integer)));
                            e.curFloor = integer;
                            e.btnMap.remove(integer);
                            factory.openDoorAction(integer);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
            //处理完成,选择电梯回归默认楼层策略
            ElecatorPolicyFactory.ElevatorAction policy = factory.getPolicy();
            policy.action(e);
        }
    }

    static class ElecatorPolicyFactory {
        /**
         * 电梯开门关门
         */
        public void openDoorAction(int floorNum) {
            System.out.println(floorNum + "层到了!");
            try {
                //close
                Thread.sleep(1 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /**
         * 电梯策略: 早高峰/晚高峰 策略
         */
        interface ElevatorAction {
            /**
             * 选择运行方式
             */
            public void action(Elevator e);
        }

        //结果为“0”是上午 结果为“1”是下午
        public static boolean curTimeIsPmOrNot() {
            GregorianCalendar ca = new GregorianCalendar();
            return ca.get(GregorianCalendar.AM_PM) != 0;
        }

        ElevatorAction getPolicy() {
            if (curTimeIsPmOrNot()) {
                return new ElevatorAction() {
                    @Override
                    public void action(Elevator e) {
                        //lift to the bottom floor
                        try {
                            if (e.curFloor == e.bottom) {
                                return;
                            }
                            Thread.sleep(5000 * (e.curFloor - e.bottom));
                            e.curFloor = e.bottom;
                            System.out.println("电梯自动调度到" + e.bottom + "层!");
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                    }
                };
            } else {
                return new ElevatorAction() {
                    @Override
                    public void action(Elevator e) {
                        //lift to the top floor
                        try {
                            if (e.curFloor == e.top) {
                                return;
                            }
                            Thread.sleep(5000 * (e.top - e.curFloor));
                            e.curFloor = e.top;
                            System.out.println("电梯自动调度到" + e.top + "层!");
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                    }
                };
            }
        }
    }

    static class User implements Runnable {
        private final Elevator ele;

        public User(Elevator ele) {
            this.ele = ele;
        }

        @Override
        public void run() {
            int i = 0;
            while (i < 100) {
                i++;
                int floor = RandomUtils.nextInt(ele.top) + 1;
                // 在该楼层按下了按钮
                System.out.println("用户" + Thread.currentThread().getName() + "在" + floor + "楼层按下了按钮");
                ele.btnMap.put(floor, new DistFloor(RandomUtils.nextInt(ele.top) + 1));
            }
        }
    }

    public static void main(String[] args) {
        Elevator e = Elevator.builder().bottom(1).top(20).btnMap(new HashMap<>())
                .curFloor(1).stat(RunningStat.INIT).build();
        new Thread(new User(e)).start();
        new Thread() {
            @Override
            public synchronized void start() {
                LiftActionPolicyFactory liftActionPolicyFactory = new MyElevatorScheduler().new LiftActionPolicyFactory();
                while (true) {
                    liftActionPolicyFactory.lift(e);
                    try {
                        thread.sleep(1000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }

                }
            }
        }.start();
    }
}
