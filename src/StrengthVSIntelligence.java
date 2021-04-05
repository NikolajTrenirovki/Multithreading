public class StrengthVSIntelligence {
    public static void main(String[] args) {
/*        int s = 10;
        int i = 0;
        int res = 0;
        for (int k = 0; k<=10; k++){
            int temp = 55*s/(s+70);
            int tempRes = temp*i*2/10;
            System.out.println(tempRes);
            if(tempRes>res){
                res = tempRes;
            }
            s--;
            i++;
        }
        System.out.println(res);*/
        int s = 40; // сила
        int i = 60; // интеллект
        int temp = 55*s/(s+70);
        int tempRes = temp*i*2/10;
        System.out.println(tempRes); // идеальное соотношение s = 40, i = 60
    }
}
