package imooc;

import java.util.*;

public class Game {  
	  
    public List<Cards> allcards;  
    public Game(){  
        this.allcards = new ArrayList<Cards>();  
          
    }  
    /** 
     * 创建一副扑克牌 
     */  
    public void setup(){  
        String design[] = {"黑桃","红桃","梅花","方片"};  
        String point[] = {"A","K","Q","J","10","9","8","7","6","5","4","3","2"};  
        for (int i = 0;i<4;i++){  
            for (int j = 0; j<13;j++){  
                Cards c = new Cards(design[i], point[j]);  
                allcards.add(c);  
            }  
        }  
    }  
    /**  
     * 通过for each方法访问集合元素  
     * 遍历打印扑克牌 
     */    
    public void printCards() {    
        System.out.println("为：");    
        for (Object obj : allcards) {    
            Cards card = (Cards) obj;    
            System.out.print(card.design + card.point + ",");    
        }    
    }    
    /** 
     * 创建玩家，输入ID和姓名 
     */  
    int id=0;  
    String name;  
    public int creatplayer(int num){  
        System.out.println("------请输入第"+ num +"位玩家ID------");  
        @SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);  
          
        //处理异常  
        try {  
            id =input.nextInt();  
        } catch (Exception e) {  
            System.out.println("请输入一个整数ID");  
            return this.creatplayer(num);  
        }         
          
        System.out.println("------请输入第"+ num +"位玩家姓名------");  
        name =input.next();  
        return 0;  
    }  
    /** 
     * 发牌 
     */  
    public void deal(Player playernum){  
        Cards card = this.allcards.get(0);  
        playernum.handcards.add(card);  
        this.allcards.remove(card);  
        System.out.println("------玩家 "+playernum.name+"拿牌------");  
    }  
      
    /** 
     * 比较牌面大小 
     */  
    public Cards pkcard(Cards a,Cards b){  
        ArrayList<String> design = new ArrayList<String>(Arrays.asList("黑桃","红桃","梅花","方片"));  
        ArrayList<String> point = new ArrayList<String>(Arrays.asList("A","K","Q","J","10","9","8","7","6","5","4","3","2"));  
        if (point.indexOf(a.point)<point.indexOf(b.point))  
            return a;  
        else if (point.indexOf(a.point)>point.indexOf(b.point))  
            return b;  
        else {  
            if (design.indexOf(a.design)>point.indexOf(b.design))  
                return b;  
            else return a;  
            }  
    }  
      
    public static void main(String[] args){  
        System.out.println("------创建扑克牌------");  
        Game game = new Game();  
        game.setup();  
        System.out.println("------扑克牌创建成功------");  
        game.printCards();  
        System.out.println();  
        System.out.println("------开始洗牌------");  
        Collections.shuffle(game.allcards);  
        System.out.println("------洗牌结束------");  
        System.out.println("------创建玩家------");  
        game.creatplayer(1);  
        Player player1 = new Player(game.id, game.name);  
        game.creatplayer(2);  
        Player player2 = new Player(game.id, game.name);  
  
        System.out.println("------欢迎玩家  " + player1.name + "和" + player2.name+"------");  
        System.out.println("------现在开始发牌------");  
        game.deal(player1);  
        game.deal(player2);  
        game.deal(player1);  
        game.deal(player2);  
        System.out.println("------发牌结束,游戏开始!------");  
        Cards temp1 = new Cards("方片", "2");  
        for (Cards c: player1.handcards)  
        {  
            temp1 = game.pkcard(temp1,c);  
        }  
        System.out.println("玩家"+player1.name+"最大的手牌为:"+temp1.design+temp1.point);  
        Cards temp2 = new Cards("方片", "2");  
        for (Cards c: player2.handcards)  
        {  
            temp2 = game.pkcard(temp2,c);  
        }  
        System.out.println("玩家"+player2.name+"最大的手牌为:"+temp2.design+temp2.point);  
        String winname;  
        if (game.pkcard(temp1,temp2)==temp1)  
            winname = player1.name;  
        else winname = player2.name;  
        System.out.println("--------恭喜玩家"+winname+"获胜!--------");  
        System.out.println("--------玩家各自手牌为：--------");  
        System.out.print(player1.name+":");  
        for (Cards c: player1.handcards)  
        {  
            System.out.print("["+c.design+c.point+"] ");  
        }  
        System.out.println();  
        System.out.print(player2.name+":");  
        for (Cards c: player2.handcards)  
        {  
            System.out.print("["+c.design+c.point+"] ");  
        }  
    }  
  
}  
