public class ArrayDispari {
    public static void main(String[] args) {
        int[] data;
        data = new int[] {11, 20, 5, 40, 7, 60, 71, 80, 3, 91};
        System.out.println("Before");
        printArray(data);
        System.out.println("After");
        moltDisp(data);

    }
    public static void moltDisp(int[] arrayInt) {
        for(int i=0; i < arrayInt.length; i ++){
            if(arrayInt[i] % 2 != 0){
                // Se dispari lo moltiplico
                arrayInt[i] *= 2;
            }
        }
        printArray(arrayInt);
    }

    public static void printArray(int[] arrayInt) {
        System.out.print("[");
        for(int i=0; i < arrayInt.length; i ++){
            System.out.print(arrayInt[i]);
            if(i != arrayInt.length - 1) System.out.print(",");

        }
        System.out.println("]");

    }
}
