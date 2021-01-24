package suanfa.interview.elevator.com.test.elevator;

import org.apache.commons.lang.math.RandomUtils;

import java.util.Queue;

import static suanfa.interview.elevator.com.test.elevator.Button.BtnDirec;

/**
 * 模拟电梯运行（单一电梯，未考虑达到承载上限，最短等待时间等问题）
 * 电梯有三种状态：静止，向上，向下。
 * 每层的指示灯有三种状态：向上、向下、到达（只开门）。
 * 开门上人1秒，每上或下一层用0.1秒。
 * 使用一个队列（可看做时间优先）将所有按钮事件依次入队，当电梯静止时首先响应队头的按钮事件，
 * 并根据按钮楼层和当前楼层的位置确定移动方向；
 * 当向上移动时，将移动到所有按钮所在楼层的最高层，当按钮方向和电梯方向一致时或该楼层内部到达按钮亮起时开门；向下移动类似。
 * 当队列中没有按钮事件时，电梯静止。
 *
 * 单线程控制电梯上下，需要同步“设置和获取电梯按钮最高层或按钮最底层数的方法”。
 * 如果考虑等待时间（电梯外）？
 *
 * 优化,早晚高峰电梯闲置回归顶层或底层,默认底层
 * 三部电梯高峰期全部调度,非高峰期调度最近的一台
 *
 *
 */
public class ElevatorMimic {
    static int top = 20;

    public static void main(String[] args) throws Exception {
        ElevatorMimic em = new ElevatorMimic();

        Elevator ele = new Elevator();
        ele.setTop(top);
        ele.setBottom(1);
        ele.setCurFloor(1);
        ele.init();

        new Thread(em.new EleStat(ele)).start();
        new Thread(em.new User(ele)).start();

        while (true) {
            if (!ele.getPushedFloor().isEmpty()) {
                int nextFloor = ele.getPushedFloor().peek();
                if (nextFloor > 0) {//向上的按钮
                    if (ele.getCurFloor() - nextFloor <= 0) {
                        ele.liftUp();
                    } else if (ele.getCurFloor() - nextFloor > 0) {
                        ele.liftDown();
                    }
                } else {//向下的按钮
                    if (ele.getCurFloor() + nextFloor < 0) {
                        ele.liftUp();
                    } else if (ele.getCurFloor() + nextFloor >= 0) {
                        ele.liftDown();
                    }
                }
            } else {
                ele.setStat(Elevator.RunningStat.INIT);
            }
            Thread.sleep(100);
        }


    }

    class User implements Runnable {
        private final Elevator ele;

        public User(Elevator ele) {
            this.ele = ele;
        }

        @Override
        public void run() {
            int i = 0;
            while (i < 5) {
                i++;
                int floor = RandomUtils.nextInt(top) + 1;
                Button btn = ele.getButton(floor);
                try {
                    if (floor == ele.top) {
                        btn.push(floor, BtnDirec.DOWN);
                    } else if (floor % 2 == 0 || floor == ele.bottom) {
                        btn.push(floor, BtnDirec.UP);
                    } else {
                        btn.push(floor, BtnDirec.DOWN);
                    }
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class EleStat implements Runnable {
        private final Elevator ele;

        public EleStat(Elevator ele) {
            this.ele = ele;
        }

        @Override
        public void run() {
            while (true) {
                printUpDownSign(ele);
                switch (ele.getStat()) {
                    case UP:
                        System.out.println("The elevator is lift up， cur:" + ele.getCurFloor());
                        break;
                    case DOWN:
                        System.out.println("The elevator is lift down， cur:" + ele.getCurFloor());
                        break;
                    case INIT:
                        System.out.println("The elevator is no moving， cur:" + ele.getCurFloor());
                        break;
                    default:
                        System.out.println(" cur:" + ele.getCurFloor());
                        break;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

        void printUpDownSign(Elevator ele) {
            Queue<Integer> q = ele.getPushedFloor();
            if (!q.isEmpty()) {
                Integer[] floors = q.toArray(new Integer[q.size()]);
                for (int i = 0; i < floors.length; i++) {
                    if (floors[i] > 0) {
                        if (ele.getButton(floors[i]).isUpLightOn()) {
                            System.out.print(floors[i] + " ↑,");
                        } else {
                            System.out.print(floors[i] + " -,");
                        }
                    } else {
                        if (ele.getButton(-1 * floors[i]).isDownLightOn()) {
                            System.out.print(-1 * floors[i] + " ↓,");
                        } else {
                            System.out.print(-1 * floors[i] + " -,");
                        }

                    }
                }
                System.out.println("");
            }
        }
    }
}
