package project7;

import java.util.*;

public class Game {
	List<Poker> allCards = new ArrayList<Poker>();
	List<Player> players = new ArrayList<Player>();
	ArrayList<String> designs = new ArrayList<String>(Arrays.asList("黑桃","红桃","梅花","方片"));  
   	ArrayList<String> points = new ArrayList<String>(Arrays.asList("A","K","Q","J","10","9","8","7","6","5","4","3","2"));

	public static void main(String[] args) {
		Game gm = new Game();
		gm.setCards();
		System.out.println();
		System.out.println("----------开始洗牌----------");
		Collections.shuffle(gm.allCards);//Collections的shuffle()方法，用于随机更改列表序列
		System.out.println("----------洗牌结束----------");
		System.out.println("----------创建玩家----------");
		System.out.println("请输入第1位玩家的ID和姓名:");
		gm.creatPlayer(1);
		gm.players.add(0,new Player(gm.id,gm.name));
		System.out.println("请输入第2位玩家的ID和姓名:");
		gm.creatPlayer(2);
		gm.players.add(1,new Player(gm.id,gm.name));
		gm.deal();
		System.out.println("--------开始游戏--------");
		gm.playerPk();
	}

	/**
	 * 创建扑克牌
	 * @param args
	 */
	public void setCards() {
		System.out.println("----------创建扑克牌----------");
		for(int i = 0;i < points.size();i++) {
			for (int j = 0;j < 4;j++) {
				Poker poker = new Poker(designs.get(j),points.get(i));
				allCards.add(poker);
			}
		}
		System.out.println("----------扑克牌创建成功----------");
		for(Poker card:allCards) {
			System.out.print(card.getDesign()+card.getPoint()+",");
		}
	}
	/**
	 * 创建玩家
	 * @param args
	 */
	int id=0;  
    String name;  
    public void creatPlayer(int num){  
        System.out.println("请输入玩家ID:");  
        @SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);    
        //处理异常  
        try {  
            id = input.nextInt();  
        } catch (Exception e) {  
            System.out.println("请输入一个整数ID"); 
            input.next();
            this.creatPlayer(num);
            return;
        
        }         
        System.out.println("请输入玩家姓名:");
        name =input.next();
    }  
	/**
	 * 发牌
	 * @param args
	 */
	public void deal() {
		System.out.println("********开始发牌********");
		for(int i = 0;i < 2;i++) {
			for(int j = 0;j < 2;j++) {
			System.out.println("----玩家:" + players.get(j).getName() + "-拿牌");
			players.get(j).handcard.add(allCards.get(0));
			allCards.remove(0);
			}
		}
		System.out.println("********发牌结束!********");
	}
	/**
	 * 比较牌面大小
	 * @param args
	 */
	public Poker pkCard(Poker a,Poker b) {
        if(points.indexOf(a.getPoint()) < points.indexOf(b.getPoint())) {
			return a;
		}else if(points.indexOf(a.getPoint()) == points.indexOf(b.getPoint())) {
			if(designs.indexOf(a.getDesign())< designs.indexOf(b.getDesign())){
				return a;
			}else {
				return b;
			}
		} else{
			return b;
		}
	}
	/**
	 * 玩家Pk
	 * @param args
	 */
	public void playerPk() {
			Poker temp[] = new Poker[2];
			for(int i = 0;i < players.size();i++) {
				Poker handpoker[] = new Poker[2];
				for(int j = 0;j < players.get(i).handcard.size();j++) {
					handpoker[j] = players.get(i).handcard.get(j);
				}
				temp[i] = pkCard(handpoker[0],handpoker[1]);
				System.out.println("玩家:" + players.get(i).getName() + "最大的手牌为:" + 
									temp[i].getDesign() + temp[i].getPoint());
			}
			if(pkCard(temp[0],temp[1]) == temp[0]){
				System.out.println("--------玩家" +players.get(0).getName() + "获胜!--------");
			}else {
				System.out.println("--------玩家" +players.get(1).getName() + "获胜!--------");
			}
			System.out.println("--------玩家各自的手牌为:--------");	
			
			for(int i = 0;i < players.size();i++) {
				Poker handpoker[] = new Poker[2];
				for(int j = 0;j < players.get(i).handcard.size();j++) {
					handpoker[j] = players.get(i).handcard.get(j);
				}
				System.out.println( players.get(i).getName() + ":" 
									+ handpoker[0].getDesign() 
									+ handpoker[0].getPoint()
									+" " + handpoker[1].getDesign() 
									+ handpoker[1].getPoint());
			}
	}	
}
