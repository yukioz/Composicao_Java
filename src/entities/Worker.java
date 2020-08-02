package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {

	private String name;
	private WorkerLevel level;
	private Double basesalary;
	
	private Department department;
	private List <HourContract> contracts = new ArrayList<>();
	
	//Construtors
	
	public Worker () {
		
		
	}

	public Worker(String name, WorkerLevel level, Double basesalary, Department department) {
		this.name = name;
		this.level = level;
		this.basesalary = basesalary;
		this.department = department;
	}
	
	//Getter ans Setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBasesalary() {
		return basesalary;
	}

	public void setBasesalary(Double basesalary) {
		this.basesalary = basesalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	
	//M�todos
	
	public void addContract (HourContract contract) {
		
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		
		contracts.remove(contract);
	}
	
	public double income (int year, int month) {
		
		double sum = basesalary;
		
		Calendar cal = Calendar.getInstance();
		
		for(HourContract c : contracts) {
			
			cal.setTime(c.getDate());
			
			//System.out.println(c.getDate() + " teste de data!!!");
			
			int c_year = cal.get(Calendar.YEAR);
			int c_month = cal.get(Calendar.MONTH + 1); // ou int c_month = 1 + cal.get(Calendar.MONTH);
			int c_day = cal.get(Calendar.DAY_OF_YEAR); // N�o est� sendo utilizadao c�digo, existe para realizar testes
			
			//System.out.println(c_day + " / " + c_month + " / " + c_year);
			
			if(year == c_year && month == c_month) {
				
				sum += c.totalValue();
			}
		}
		
		return sum;
	}
	
}
