public class Main{
    static String[][] Einstein = new String[5][5];
    final static String[][] options = {
        {"Red", "Blue", "Yellow", "White", "Green"},  // House Colors
        {"German", "Brit", "Swede", "Dane", "Norwegian"},  // Nationalities
        {"Water", "Tea", "Beer", "Coffee", "Milk"},  // Drinks
        {"Pall Mall", "Dunhill", "Blends", "Blue Master", "Prince"},  // Cigarette Brands
        {"Fish", "Cats", "Birds", "Dogs", "Horses"}  // Pets
    };
    final static int normal = 5;
    final static int side = 4;
    final static int next = 3;
    public static void main(String[] args){
        clean();
        one(0);
        printContainer();
    }


    public static void print(){
        int i;
        for(i = 0; i < 5; i++){
            switch (i) {
                case 0:
                    System.out.println("Colors:");
                    break;
                case 1:
                    System.out.println("Nationality:");
                    break;
                case 2:
                    System.out.println("Beverage:");
                    break;
                case 3:
                    System.out.println("Cigarette Brand:");
                    break;
                case 4:
                    System.out.println("Pet:");
                    break;
            }
            
            System.out.printf("%-15s %-15s %-15s %-15s %-15s \n\n", options[i][0], options[i][1], options[i][2], options[i][3], options[i][4]);
        }
    }

    public static void printContainer(){
        int i;
        for(i = 0; i < 5; i++){
            // switch (i) {
            //     case 0:
            //         System.out.println("Colors:");
            //         break;
            //     case 1:
            //         System.out.println("Nationality:");
            //         break;
            //     case 2:
            //         System.out.println("Beverage:");
            //         break;
            //     case 3:
            //         System.out.println("Cigarette Brand:");
            //         break;
            //     case 4:
            //         System.out.println("Pet:");
            //         break;
            // }
            
            System.out.printf("%-15s %-15s %-15s %-15s %-15s \n", Einstein[i][0], Einstein[i][1], Einstein[i][2], Einstein[i][3], Einstein[i][4]);
        }
    }
    public static void clean(){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                Einstein[i][j] = "";
            }
        }
    }

    public static void solve(){
        int i = 0;
        while(!one(i))
            break;
    }

    public static void preciseClean(String s, String t){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if (Einstein[i][j].equals(s) || Einstein[i][j].equals(t))
                    Einstein[i][j] = "";
            }
        }
    }

    public static boolean one(int i){
        clean();
        if (i==5){
            return false;
        } else if(Einstein[0][i].isEmpty() && Einstein[1][i].isEmpty()){
            Einstein[0][i] = "Red";
            Einstein[1][i] = "Brit";
            if (two(0)){
                Einstein[0][1] ="Blue";
                return true;
            } else if (i < 5)
                two(i+1);
        }
        return one(i+1);    
    }

    public static boolean two(int i){ 
        preciseClean("Swede", "Dog");
        if (i==normal){
            return false;
        } else if(Einstein[1][i].isEmpty() && Einstein[4][i].isEmpty()){
            Einstein[1][i] = "Swede";
            Einstein[4][i] = "Dog";
            if (three(0))
                return true;
            else if (i < 5)
                three(i+1);
        } 
        return two(i+1);
    }

    public static boolean three(int i){
        preciseClean("Dane", "Tea");
        if (i==normal){
            return false;
        } else if(Einstein[1][i].isEmpty() && Einstein[2][i].isEmpty()){
            Einstein[1][i] = "Dane";
            Einstein[2][i] = "Tea";
            if (four(0))
                return true;
            else if (i < 4)
                four(i+1);
        }
        return three(i+1);
    }

    public static boolean four(int i){
        preciseClean("Green", "White");
        if (i==side){
            return false;
        } else if(Einstein[0][i].isEmpty() && Einstein[0][i+1].isEmpty()){
            Einstein[0][i] = "Green";
            Einstein[0][i+1] = "White";
            if (five(0))
                return true;
            else if (i < 5)
                five(i+1);
        }
        return four(i+1);
    }

    public static boolean five(int i){
        preciseClean("", "Coffee");
        if (i==normal){
            return false;
        } else if(Einstein[0][i].equalsIgnoreCase("Green") && Einstein[2][i].isEmpty()){
            Einstein[2][i] = "Coffee";
            if (six(0))
                return true;
            else if (i < 5)
                six(i+1);
        }
        return five(i+1);
    }
    
    public static boolean six(int i){
        preciseClean("Pall Mall", "Bird");
        if (i==normal){
            return false;
        } else if(Einstein[3][i].isEmpty() && Einstein[4][i].isEmpty()){
            Einstein[3][i] = "Pall Mall";
            Einstein[4][i] = "Bird";
            if (seven(0))
                return true;
            else if (i < 5)
                seven(i+1);
        }
        return six(i+1);
    }

    public static boolean seven(int i){
        
        preciseClean("Yellow", "Dunhill");
        if (i==normal){
            return false;
        } else if(Einstein[0][i].isEmpty() && Einstein[3][i].isEmpty()){
            Einstein[0][i] = "Yellow";
            Einstein[3][i] = "Dunhill";
            if (eight())
                return true;
        }
        return seven(i+1);
    }

    public static boolean eight(){
        preciseClean("Milk", "");
        if(Einstein[2][2].isEmpty()){
            Einstein[2][2] = "Milk";
            if (nine())
                return true;
        }
        return false;
    }
    
    public static boolean nine(){
        preciseClean("Norwegian", "");
        if(Einstein[1][0].isEmpty()){
            Einstein[1][0] = "Norwegian";
            if(ten(1))
                return true;
        }
        return false;
    }

    public static boolean ten(int i){
        
        preciseClean("Cat", "Blends");
        if (i==normal){
            return false;
        } else if(i > 0 && Einstein[3][i].isEmpty() && Einstein[4][i-1].isEmpty()){
            Einstein[3][i] = "Blends";
            Einstein[4][i-1] = "Cat";
            if(eleven(0))
                return true;
            else if (i < 5)
                eleven(i+1);
        } else if(i < 4 && Einstein[3][i].isEmpty() && Einstein[4][i+1].isEmpty()){
            Einstein[3][i] = "Blends";
            Einstein[4][i+1] = "Cat";
            if(eleven(0))
                return true;
            else if (i < 5)
                eleven(i+1);
        }
        return ten(i+1);
    }
    
    public static boolean eleven(int i){
        
        preciseClean("Horse", "");
        if (i==normal){
            return false;
        } else if(i > 0 && Einstein[3][i].equalsIgnoreCase("Dunhill") && Einstein[4][i-1].isEmpty()){
            Einstein[4][i-1] = "Horse";
            if(twelve(0))
                return true;
            else if (i < 5)
                twelve(i+1);
        } else if(i < 4 && Einstein[3][i].equalsIgnoreCase("Dunhill") && Einstein[4][i+1].isEmpty()){
            Einstein[4][i+1] = "Horse";
            if(twelve(0))
                return true;
            else if (i < 5)
                twelve(i+1);
        }
        return eleven(i+1);
    }

    public static boolean twelve(int i){
        
        preciseClean("Blue Master", "Beer");
        if (i==normal){
            return false;
        } else if(Einstein[2][i].isEmpty() && Einstein[3][i].isEmpty()){
            Einstein[2][i] = "Beer";
            Einstein[3][i] = "Blue Master";
            if (thirteen(0))
                return true;
            else if (i < 5)
                thirteen(i+1);
        }
        return twelve(i+1);
    }

    public static boolean thirteen(int i){
        
        
        preciseClean("German", "Prince");
        if (i==normal){
            return false;
        } else if(Einstein[1][i].isEmpty() && Einstein[3][i].isEmpty()){
            Einstein[1][i] = "German";
            Einstein[3][i] = "Prince";
            if (fourteen(0))
                return true;
            else if (i < 5)
                if(fifteen(i+1))
                    return true;
        }
        return thirteen(i+1);
    }

    public static boolean fourteen(int i){
        
        preciseClean("Blue", "");
        if(i==normal){
            return false;
        } else if(i > 0 && Einstein[1][i].equals("Norwegian") && Einstein[0][i-1].isEmpty()){
            Einstein[0][i-1] = "Blue";
            if (Einstein[0][1].equals("Blue"))
                printContainer();
            if (fifteen(0))
                return true;
            else if (i < 5)
                if(fifteen(i+1))
                    return true;
        } else if(i < 4 && Einstein[1][i].equals("Norwegian") && Einstein[0][i+1].isEmpty()){
            Einstein[0][i+1] = "Blue";
            if (fifteen(0))
                return true;
            else if (i < 5)
                if(fifteen(i+1))
                    return true;
        }
        return fourteen(i+1);

    }

    public static boolean fifteen(int i){
        preciseClean("Water", "");
        if(i==normal){
            return false;
        } else if(i > 0 && Einstein[3][i].equals("Blends") && Einstein[2][i-1].isEmpty()){
            Einstein[2][i-1] = "Water";
            return true;
        } else if(i < 4 && Einstein[3][i].equals("Blends") && Einstein[2][i+1].isEmpty()){
            Einstein[2][i+1] = "Water";
            return true;
        }
        return fourteen(i+1);
    }
    

}