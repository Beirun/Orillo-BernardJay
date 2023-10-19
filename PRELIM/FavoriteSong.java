public class FavoriteSong {
    public static void main(String[] args) {
        String[] arr = {" 僕の心、雨に降られて\n"," 君の心、はなればなれ\n"," 二人の恋は宙に舞っていく\n"," タバコみたいに燃えてく\n"};
        for(int i = 0; i < 4; i++){
            for(int j=0; j< 5; j++){
                if(j!=4) System.out.print("ゆら");
                else System.out.print(arr[i]);
            }
        }
    }
}
