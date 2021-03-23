package neuralnetwork;

import java.util.*;


public class A {
    private static double[][] datas = new double[][]{
            {0, 0},
            {0, 1},
            {1, 0},
            {1, 1}
    };
    private static Integer[] integers = new Integer[]{0, 1, 1, 1};
    private static double[] wights = new double[3];
    private static double d = 0.0001;
    private static double trainRate = 0.1;
    private static int count = 0;
    private static double stop = 0.0001;
    private static List<Double> errors = new ArrayList<>();

    public static void main(String[] args) {
        A a = new A();
        double[] data;
        for (int i = 0; ; i++) {
            data = new double[]{datas[i % datas.length][0], datas[i % datas.length][1]};
            if (a.train(data, integers[i % datas.length]) == true) {
                break;
            }
        }
        System.out.println(Arrays.toString(wights));
    }

    public A() {
        for (int i = 0; i < 3; i++) {
            wights[i] = (Math.random() - 0.5);
        }
    }

    //输出计算方法
    private double calcOutput(double[] intputs) {
        double output = intputs[0] * wights[0] + intputs[1] * wights[1] + 1 * wights[2];
        return sigmoid(output);
    }

    //sigmoid函数，定义域（-，+），值域(0,1)
    private double sigmoid(double x) {
        return 1 / (1 + Math.pow(Math.E, -x));
    }

    //计算输出与预期的绝对值
    private double errRate(double output, double expceted) {
        return Math.abs(output - expceted);
    }

    //计算N次误差的平均值
    private double calcErr(double err, int maxError) {
        errors.add(err);
        if (errors.size() > maxError) {
            errors.remove(0);
        }
        double era = 0;
        for (double i : errors) {
            era += i;
        }
        return era / errors.size();
    }

    //训练
    private boolean train(double[] inputs, double expceted) {
        double err = errRate(calcOutput(inputs), expceted);
        double[] dw = new double[wights.length];

        for (int i = 0; i < wights.length; i++) {
            double w = wights[i];
            wights[i] += d;

            double err2 = errRate(calcOutput(inputs), expceted);
            dw[i] = (err2 - err) / d;
            wights[i] = w;
        }

        for (int i = 0; i < wights.length; i++) {
            wights[i] -= dw[i] * trainRate;
        }

        double e = calcErr(err, 20);
        count++;
        if (count % 5000 == 0) {
            System.out.println("count :" + count + " # " + e);
        }
        return e < stop;
    }

}
