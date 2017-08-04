package imooc;

import java.util.*;

public class Game {  
	  
    public List<Cards> allcards;  
    public Game(){  
        this.allcards = new ArrayList<Cards>();  
          
    }  
    /** 
     * ����һ���˿��� 
     */  
    public void setup(){  
        String design[] = {"����","����","÷��","��Ƭ"};  
        String point[] = {"A","K","Q","J","10","9","8","7","6","5","4","3","2"};  
        for (int i = 0;i<4;i++){  
            for (int j = 0; j<13;j++){  
                Cards c = new Cards(design[i], point[j]);  
                allcards.add(c);  
            }  
        }  
    }  
    /**  
     * ͨ��for each�������ʼ���Ԫ��  
     * ������ӡ�˿��� 
     */    
    public void printCards() {    
        System.out.println("Ϊ��");    
        for (Object obj : allcards) {    
            Cards card = (Cards) obj;    
            System.out.print(card.design + card.point + ",");    
        }    
    }    
    /** 
     * ������ң�����ID������ 
     */  
    int id=0;  
    String name;  
    public int creatplayer(int num){  
        System.out.println("------�������"+ num +"λ���ID------");  
        @SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);  
          
        //�����쳣  
        try {  
            id =input.nextInt();  
        } catch (Exception e) {  
            System.out.println("������һ������ID");  
            return this.creatplayer(num);  
        }         
          
        System.out.println("------�������"+ num +"λ�������------");  
        name =input.next();  
        return 0;  
    }  
    /** 
     * ���� 
     */  
    public void deal(Player playernum){  
        Cards card = this.allcards.get(0);  
        playernum.handcards.add(card);  
        this.allcards.remove(card);  
        System.out.println("------��� "+playernum.name+"����------");  
    }  
      
    /** 
     * �Ƚ������С 
     */  
    public Cards pkcard(Cards a,Cards b){  
        ArrayList<String> design = new ArrayList<String>(Arrays.asList("����","����","÷��","��Ƭ"));  
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
        System.out.println("------�����˿���------");  
        Game game = new Game();  
        game.setup();  
        System.out.println("------�˿��ƴ����ɹ�------");  
        game.printCards();  
        System.out.println();  
        System.out.println("------��ʼϴ��------");  
        Collections.shuffle(game.allcards);  
        System.out.println("------ϴ�ƽ���------");  
        System.out.println("------�������------");  
        game.creatplayer(1);  
        Player player1 = new Player(game.id, game.name);  
        game.creatplayer(2);  
        Player player2 = new Player(game.id, game.name);  
  
        System.out.println("------��ӭ���  " + player1.name + "��" + player2.name+"------");  
        System.out.println("------���ڿ�ʼ����------");  
        game.deal(player1);  
        game.deal(player2);  
        game.deal(player1);  
        game.deal(player2);  
        System.out.println("------���ƽ���,��Ϸ��ʼ!------");  
        Cards temp1 = new Cards("��Ƭ", "2");  
        for (Cards c: player1.handcards)  
        {  
            temp1 = game.pkcard(temp1,c);  
        }  
        System.out.println("���"+player1.name+"��������Ϊ:"+temp1.design+temp1.point);  
        Cards temp2 = new Cards("��Ƭ", "2");  
        for (Cards c: player2.handcards)  
        {  
            temp2 = game.pkcard(temp2,c);  
        }  
        System.out.println("���"+player2.name+"��������Ϊ:"+temp2.design+temp2.point);  
        String winname;  
        if (game.pkcard(temp1,temp2)==temp1)  
            winname = player1.name;  
        else winname = player2.name;  
        System.out.println("--------��ϲ���"+winname+"��ʤ!--------");  
        System.out.println("--------��Ҹ�������Ϊ��--------");  
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
