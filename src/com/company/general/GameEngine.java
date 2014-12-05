package com.company.general;

public class GameEngine {
	
	public int[] cells = {0,0,0,0,0,0,0,0,0} ;
	
	public String status="PlayerOneNext";
	public String playerOne = null;
	public String playerTwo = "?";
	
	public void setCell(int index, int value){
		this.cells[index] = value;
	};
	
	// Устанавливает значения ссылок в соответствующие ячейки с соответствующими GET параметрами
	public String getJSPReferenceValue(int index, String Player){
		String result= "";
		if(cells[index]==0) {
			
			
			result = "/play?username="+Player+"&index="+index;}
			return result;
	}  
    // Возвращает значение адреса картинки в соответствии с крестиком или ноликом
	
	public String getImage(int index) {
		if(cells[index] == 0) return "z.gif";
		else return (cells[index] == 1)?"x.gif":"o.gif";
		
	}
	
	public void makeAMove(int index, String Player){
		cells[index]= (Player.equals(playerOne))?(1):(2);//Ход
		
		
		this.status = getStatus(Player.equals(playerOne)?(playerTwo):(playerOne));
		if(status.contains("Win")||status.contains("Draw")) 
		status = new StringBuilder(status).append(" <a href=\"/play?username="+Player+"&new=yes\"> Начать новую игру</a>").toString();
	};
	
	public String getStatus(String Player)
	{
			
		for(int i = 0; i<3; i++){
				if((cells[i]!=0)&&(cells[i]==cells[i+3])&&(cells[i]==cells[i+6]))  //Проверка по вертикали
				return Player +" Win!";	
						} 
		
		if((cells[0]!=0)&&(cells[0]==cells[1])&&(cells[0]==cells[2])) return (cells[0]==1?playerOne:playerTwo +" Win!");
		if((cells[3]!=0)&&(cells[3]==cells[4])&&(cells[3]==cells[5])) return (cells[3]==1?playerOne:playerTwo +" Win!");
		if((cells[6]!=0)&&(cells[6]==cells[7])&&(cells[6]==cells[8])) return (cells[6]==1?playerOne:playerTwo +" Win!");
		
		if((cells[0]!=0)&&(cells[0]==cells[4])&&(cells[0]==cells[8]))  //Проверка по диагонали
			return (cells[0]==1?playerOne:playerTwo +" Win!");	
		
		if((cells[2]!=0)&&(cells[2]==cells[4])&&(cells[2]==cells[6]))  //Проверка по диагонали
			return (cells[2]==1?playerOne:playerTwo +" Win!");	
		
		int count = 0;
		for(int i = 0; i<=8; i++){
		if(cells[i]!=0) count++ ;	
		if (count==9)return "Draw";}//Проверка на ничью
			
		return "Player "+Player+" Next";
	}
	
	
	public GameEngine(String username){
		this.playerOne = username;
		this.status = getStatus(username);
		
	};
	
	public void addPlayer(String name){
		this.playerTwo = name;
	}
	
	public void startNewGame(){
		for(int i=0; i<9;i++) cells[i]=0;
		//this.status = "Next";		
	}
	
	
	
}
