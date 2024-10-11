import java.awt.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class Main {
    static DecimalFormat decimalFormat = new DecimalFormat("0.00");

    public static void main(String[] args) {
        //Значения по номеру бригады
        double R = 10;
        double R_k = 10;
        double L = 10;
        double U = 10;

        //Частота
        double f = 100;

        //Расчетные значения
//        for(int i=0; i<5; i++){
//            Caclulate(f, R, R_k, L, U);
//            f += 100;
//        }


        //GraphicDraw gd = new GraphicDraw();


    }

    public static void print(String s, double var){
        System.out.println(s + decimalFormat.format(var));
    }

    public static void Caclulate(double f, double R, double R_k, double L, double U){
        System.out.println("Расчеты для частоты " + f + "\n");
        double w = 2 * Math.PI * f;
        double x_l = L * w * 1E-3;

        print("x_l = ", x_l);

        double fi_estimated =Math.toDegrees(Math.atan(x_l / R));
        print("Угол fi расчетный, град = ", fi_estimated);

        double Z = Math.sqrt(Math.pow(R, 2) + Math.pow(x_l, 2));
        print("Z, Ом = ", Z);

        double Z_k = Math.sqrt(Math.pow(R_k + R, 2) + Math.pow(x_l, 2));
        print("Z_k, Ом = ", Z_k);

        double I = U * 1E3/Z_k;
        print("I, мА = ", I);


        double U_k_estimated = U * Math.sqrt(
                (Math.pow(R_k, 2) + Math.pow(x_l, 2)) / (Math.pow(R_k + R, 2) + Math.pow(x_l, 2))
        );
        print("U_k расчетное, В = ", U_k_estimated);

        double U_r_estimated = R * R_k / Z_k;
        print("U_r расчетное, В = ", U_r_estimated);

        System.out.println("\nКонец расчетов\n");
    }
}