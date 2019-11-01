import java.util.ArrayList;

public class Program {

	private ArrayList<Rule> ruleSet;
	private int currentState;
	
	public Program() {
		this.ruleSet = new ArrayList<Rule>();
		this.currentState = 0;
	}
	
	public Program(ArrayList<Rule> ruleSet) {
		this.ruleSet = ruleSet;
		this.currentState = 0;
	}
	
	public void addRule(Rule rule){
		this.ruleSet.add(rule);
	}

	public void run(Tape tape){
		boolean finish = false;
		int count = 0;
		System.out.println("Initial configuration: ");
		tape.printTapeHead();
		while (finish == false){
			
			for (Rule rule: ruleSet){
				if ((tape.read() == rule.getCharRead()) && (rule.getState() == this.currentState)){
					if (rule.getCharWrite() != -1){
						tape.write(rule.getCharWrite());
					}
					
					if (rule.getMove() == 0){
						tape.moveLeft();
					}else if (rule.getMove() == 1){
						tape.moveRight();
					}
					
					this.currentState = rule.getTransition();
					
					if (this.currentState != -1){
						System.out.println("Iteration: " + count);
						tape.printTapeHead();
						count++;
					}
					
				}
			}
			if (this.currentState == -1){
				finish = true;
			}
		}
	}
	
	public void printRuleSet(){
		for (Rule rule: this.ruleSet){
			System.out.println(rule.toString());
		}
	}
}