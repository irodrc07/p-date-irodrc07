package es.unileon.prg1.date;

public class Date {
	private int day;
	private int month;
	private int year;
	

	public Date(){
		this.day= 1;
		this.month= 1;
		this.year= 2018;
 

	}
	
	public Date(int day, int month, int year) throws DateException{
		
		StringBuffer message=new StringBuffer();

		if (day<=0){
			message.append("Incorrecto. Los dias no pueden ser negativos.");
		}

		if (month <=0){
			message.append("Incorrecto. Los meses no pueden ser negativos.");
		}else{
			if (month > 12){
			message.append("No puede haber mas de 12 meses");
				}else{
					if(day >this.daysOfMonth(month)){
						message.append("Laa combinacion de mes y dia no es correcta");
					}
				}
		}

		if(year<0){
			message.append("Los años no pueden ser negativos");
		}

		if(message.length()!=0){
			throw new DateException(message.toString());

		}else{
			this.day=day;
			this.month=month;
			this.year=year;
		}
	}

	
	private int daysOfMOnth( int month){
		int num=0;
		switch(month){
		case 1:
 		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			num=31;
			break;

		case 4:
		case 6:
		case 9:
		case 11:
			num=30;
			break;
		case 2:

			num=28;
			break;
		default:
			num=-1;
		}
		return num;
	}

	private boolean isDayRight(int day){
		return((day>0)&&(day<=this.daysOfMonth(this.month)));
	}

	
	public Date(Date another){
		this.day =another.getDay();
       		this.month =another.getMonth();
		this.Year=another.getYear();

	}
	
	public int getDay(){
		return this.day;
	}
	
	public int setDay(int day)throws DateException{
		if(day<=0){
			throw new DateException("Los dias no pueden ser negativos");
		}else{
			if(!this.isDayRight(day)){
				throw new DateException("No es correcto");
			}else{
				this.day=day;
			}
		}
	}

	public int getMonth(){
		return this.month;
	}

	public int setMonth(int Month) throws DateException{
		if(month<=0){
			throw new DateException("Los meses no pueden ser negativos");
		}else{
			if(month>12){
				throw new DateException("No es correcto solo hay 12 meses");
			}else{
				this.month=month;
			}
		}

	}

	public int getYear(){
		return this.year;
	}

	public int setYear(int year)throws DateException{
		if(year<0){
			throw new DateException("Los años no pueden ser negativos");
		}else{
			this.month=month;
		}
		
	}


	public Date tomorrow(){
		Date tomorrow=null;
		int dia,mes,anio;
			
		d= this.day;
		m=this.month;
		y=this.year;

		d++;
		if(d>this.daysOfMonth(month)){
			d=1;
			m++;
			if(m>12){
				m=1;
				y++;
			}
		}

		try{
			tomorrow=new Date(d,m,y);
		}catch(DateException e){
			System.err.ptintln(e.getMessage());
		}
		
		return tomorrow;
	}

	public boolean isSameDay(Date other){
		if(this.day== other.getDay(){
			return true;
		}else{
			return false;
		}
	}

	public boolean isSameMonth(Date other){
		if(this.month== other.getMonth(){
			return true;
		}else{
			return false;
		}
	}

	public boolean isSameYear(Date other){
		return this.year== other.year();
			
	}
			
	public boolean isSame(Date other){
		return this.isSameDay(other) &&  this.isSameMonth(other) &&  this.isSameYear(other);
			
	}	
	

	public String getMonthName(){
		String name= null;
		switch(this.month){
		case 1:
			name= "January";
			break;
		case 2:
			name= "February";
			break;
		case 3:
			name= "March";
			break;
		case 4:
			name= "April";
			break;
		case 5:
			name= "May";
			break;
		case 6:
			name= "June";
			break;
		case 7:
			name= "July";
			break;
		case 8:
			name= "August";
			break;
		case 9:
			name= "September";
			break;
		case 10:
			name= "October";
			break;
		case 11:
		
			name= "November";
			break;
		case 12:
			name= "December";
			break;
		}return name;
	}

	public int dayOfMonth(){
		return this.dayOfMonth(this.month);
	}

	public String getSeasonName(){
		String name=null;
		
		switch(this.month){
		case 1:
		case 2:	
		case 3:
			name ="Winter";
			break;	
		case 4:
		case 5:	
		case 6:
			name="Spring";
			break;
			
		case 7:	
		case 8:	
		case 9:
			name="Summer";
			break;
			
		case 10:
		case 11:
		case 12:
			name="Autum";
			break;
			
		}return name;
	}

	public String getDaysOfMotnhLeft(){
		Date aux=tomorrow();
		StringBuffer daysLeft=new StringBuffer();
		try{
			for (int  i=aux.getDay(); isDayRigth(i); i++){
				aux.setDay(i);
				daysLeft.append(aux.toString()+"");
			}
		}catch(DateException e){
			System.err.println(e.getMssage());
		}
		return daysLeft.toString();
	}



	public String getMonthLeft(){
		Date aux=new Date(this);
		StringBuffer monthsLeft = new StringBuffer();
		try{
			for (int  i=this.month+1; i<=12; i++){
				aux.setMonth(i);
				daysLeft.append(aux.getMonthName()+"");
			}
		}catch(DateException e){
			System.err.println(e.getMssage());
		}
		return daysLeft.toString();
	}
	

	public String getMonthsSameDays(){
		Date aux=new Date(this);
		StringBuffer monthsLeft=new StringBuffer();
		try{
			for (int  i=1; i<=12; i++){
				aux.setMonth(i);
				if(aux.daysOfMonth()==this.daysOfMonth()){
				months.append(aux.getMonthName()+"");
				}
			}
		}catch(DateException e){
			System.err.println(e.getMssage());
		}
		return months.toString();
	}



	public int daysPast(){
		int result;
		result=0;
	
		try{
			Date aux=new Date(1,1,this.year);
			for( int i=1; i<this.month; i++){
				result += aux.daysOfMonth();
				aux.setMonth(i+1);
			}
	
		}catch(DateException e){
			System.err.println(e.getMssage());
		}

		return reult+this.day-1;
	}

	public String NameOfDay(int day){
		String dayName;
		switch(day){

		case 1:
			dayName= "Monday";
			break;
		case 2: 
			dayName= "Tuesday";
			break;
		case 3: 
			dayName= "Wednesday";
			break;
		case 4: 
			dayName= "Thursday";
			break;
		case 5: 
			dayName= "Friday";
			break;
		case 6:
			dayName= "Saturday";
			break;
		case 7:
			dayName= "Sunday";
			break;
		default:
			dayName="Wrong"

		}return dayName;
	}



	public String daysOfweek(int firstOfJanuary){
		int dayNum;
		dayNum=(daysPast()%7+firstOfJanuary)%7;
		return nameOfDay(dayNum);
	}

	public String toString(){
		return this.day+"/"+this.month+"/"+this.year;
	}

	public int numRandomTriesEqualDate(){
		int tries, d,m,y;
		tries=0;
		try{
			do{
				d=(int)(Math.random()*this.daysOfMonth(m))+1;
				m=(int)(Math.random()*12)+1;
				y=this.year;

			}while(!this.isSame(new Date(d,m,y)));
			}catch(DateException e){
			System.err.println(e.getMssage());
		}return tries;
	}
}
















































