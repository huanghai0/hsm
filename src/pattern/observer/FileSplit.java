package pattern.observer;

import java.util.List;

public class FileSplit {
    List<IProgress> list;

    public FileSplit(List<IProgress> list) {
        this.list = list;
    }

    public void addIProgressList(IProgress iProgress) {
        list.add(iProgress);
    }

    public void removeIProgressList(IProgress iProgress) {
        list.remove(iProgress);
    }

    public void split() {
        for (int i = 0; i < 3; i++) {
            doProgress(i);
        }
    }

    private void doProgress(int i) {
        list.stream().forEach((iProgress) -> {
            iProgress.onShow(i);
        });

//        for (IProgress iProgress : list){
//            iProgress.onShow();
//        }
    }
}
