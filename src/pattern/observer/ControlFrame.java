package pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class ControlFrame {


    public static void main(String[] args) {
        List<IProgress> list = new ArrayList<>();
        FileSplit fileSplit = new FileSplit(list);
        IProgress aProgress = new AProgress();
        IProgress bProgress = new BProgress();

        fileSplit.addIProgressList(aProgress);
        fileSplit.addIProgressList(bProgress);

        fileSplit.split();
    }

}

class AProgress implements IProgress {

    @Override
    public void onShow(int i) {
        System.out.println("第{" + i + "}通知到 ->A");
    }
}

class BProgress implements IProgress {


    @Override
    public void onShow(int i) {
        System.out.println("第{" + i + "}通知到 ->B");
    }
}
