package suanfa.interview.elevator.com.test.elevator;

import org.apache.commons.lang.math.RandomUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;


public class Elevator {

    /**
     * 运行状态
     */
    RunningStat stat = RunningStat.INIT;
    /**
     * 最高层
     */
    int top;
    /**
     * 最底层
     */
    int bottom;
    /**
     * 上升到的最高层
     */
    int liftTop;

    /**
     * 下降到的最底层
     */
    int liftBottom;
    /**
     * 被按下的楼层列表,正数表示向上，负数表示向下
     */
    Queue<Integer> pushedFloor;

    int curFloor = 1;

    /**
     * 所有外部按钮
     */
    Map<Integer, Button> btnMap;

    public void liftUp() throws InterruptedException {
        setStat(RunningStat.UP);
        int floorIdx = curFloor;
        while (floorIdx <= this.getLiftTop()) {
            curFloor = floorIdx;
            if (btnMap.get(floorIdx).isUpLightOn()) {
                openDoor(floorIdx, true);
                btnMap.get(floorIdx).setUpLightOn(false);
            } else if (btnMap.get(floorIdx).isInnerLightOn()) {
                justOpenDoor(floorIdx);
            }
            /**
             * 模拟电梯上升
             */
            Thread.sleep(100);
            floorIdx++;
        }
        synchronized (this) {
            //需要注意，若“当前层”达到最高层需重新初始化最高层指示变量
            if (this.getLiftTop() == curFloor) {
                this.setLiftTop(bottom - 1);
            }
        }
    }

    public void liftDown() throws InterruptedException {
        setStat(RunningStat.DOWN);
        int floorIdx = curFloor;
        while (floorIdx >= this.getLiftBottom()) {
            curFloor = floorIdx;
            if (btnMap.get(floorIdx).isDownLightOn()) {
                openDoor(floorIdx, false);
                btnMap.get(floorIdx).setDownLightOn(false);
            } else if (btnMap.get(floorIdx).isInnerLightOn()) {
                justOpenDoor(floorIdx);
            }
            /**
             * 模拟电梯下降时间
             */
            Thread.sleep(100);
            floorIdx--;
        }
        synchronized (this) {
            //如果到达最高层
            if (this.getLiftBottom() == curFloor) {
                this.setLiftBottom(top + 1);
            }
        }
    }

    /**
     * 添加上升到的楼层，内部按钮
     * @param floor
     * @throws InterruptedException
     */
    protected void addUpFloor(int floor) throws InterruptedException {
        synchronized (this) {
            if (!pushedFloor.contains(floor)) {
                pushedFloor.offer(floor);
            }
            setUpDownFloor(floor);
        }
    }

    /**
     * 下降到的楼层
     * @param floor
     * @throws InterruptedException
     */
    protected void addDownFloor(int floor) throws InterruptedException {
        synchronized (this) {
            /**
             * -1 表示向下
             */
            if (!pushedFloor.contains(-1 * floor)) {
                pushedFloor.offer(-1 * floor);
            }
            setUpDownFloor(floor);
        }
    }

    protected void addInnerFloor(int floor) throws InterruptedException {
        synchronized (this) {
            if (!pushedFloor.contains(floor)) {
                pushedFloor.offer(floor);
            }
            this.getButton(floor).setInnerLightOn(true);
            setUpDownFloor(floor);
        }
    }

    private void setUpDownFloor(int floor) {
        if (floor > this.getLiftTop()) {
            this.setLiftTop(floor);
        }
        if (floor < this.getLiftBottom()) {
            this.setLiftBottom(floor);
        }
    }

    private void justOpenDoor(int floor) throws InterruptedException {
        this.getButton(floor).setInnerLightOn(false);
        System.out.println("just opening door on floor: " + floor);
        pushedFloor.remove(floor);
        /** 等待1秒，模拟按按钮事件 */
        Thread.sleep(1000);

    }

    private void openDoor(int floor, boolean isUp) throws InterruptedException {
        int inter = 0;
        if (isUp) {
            if (pushedFloor.contains(floor)) {
                pushedFloor.remove(floor);
            }
            this.getButton(floor).setUpLightOn(false);
            this.getButton(floor).setInnerLightOn(false);
            //随机产生一个要上升到的楼层
            inter = floor + RandomUtils.nextInt(top - floor) + 1;
            addInnerFloor(inter);
        } else {
            if (pushedFloor.contains(-1 * floor)) {
                pushedFloor.remove(-1 * floor);
            }
            this.getButton(floor).setDownLightOn(false);
            this.getButton(floor).setInnerLightOn(false);

            inter = floor - RandomUtils.nextInt(floor - bottom) - 1;
            addInnerFloor(inter);
        }
        System.out.println("opening door on floor: " + floor + " lift to:" + inter);

        /**
         * 等待1秒，模拟按按钮事件
         */
        Thread.sleep(1000);

    }

    /**
     * 初始化电梯
     */
    public void init() throws Exception {
        if (top < 1 || top <= bottom) {
            throw new Exception("hehehe~~");
        }
        btnMap = new HashMap<Integer, Button>();
        for (int i = 1; i <= top; i++) {
            btnMap.put(i, new Button(this));
        }
        this.setLiftBottom(top + 1);
        this.setLiftTop(bottom - 1);
        this.setPushedFloor(new ConcurrentLinkedQueue<Integer>());
        System.out.println("The elevator started");
    }

    public final int getCurFloor() {
        return curFloor;
    }


    public final void setCurFloor(int curFloor) {
        this.curFloor = curFloor;
    }

    public final int getTop() {
        return top;
    }


    public final void setTop(int top) {
        this.top = top;
    }


    public final int getBottom() {
        return bottom;
    }


    public final void setBottom(int bottom) {
        this.bottom = bottom;
    }


    public final RunningStat getStat() {
        return stat;
    }


    public final void setStat(RunningStat stat) {
        this.stat = stat;
    }


    public synchronized final int getLiftTop() {
        return liftTop;
    }

    public synchronized final void setLiftTop(int liftTop) {
        this.liftTop = liftTop;
    }

    public synchronized final int getLiftBottom() {
        return liftBottom;
    }

    public synchronized final void setLiftBottom(int liftBottom) {
        this.liftBottom = liftBottom;
    }

    public final Queue<Integer> getPushedFloor() {
        return pushedFloor;
    }

    public final void setPushedFloor(Queue<Integer> pushedFloor) {
        this.pushedFloor = pushedFloor;
    }

    public Button getButton(int floor) {
        return btnMap.get(floor);
    }

    enum RunningStat {
        INIT, UP, DOWN
    }


}
