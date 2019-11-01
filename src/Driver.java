import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		System.out.println("Enter rules as comma separated quints (state, read, write, move, transition)");
		System.out.println("Spaces are represented by -1");
		System.out.println("Moving left is 0, right is 1");
		System.out.println("final state transition is -1");
		System.out.println();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter initial tape config: ");
		String tapeInput = scanner.nextLine();
		tapeInput = tapeInput.replaceAll("\\s+","");
		System.out.println();
		int negCount = 0;
		for (int i = 0; i < tapeInput.length(); i++){
			if (tapeInput.charAt(i) == '-'){
				negCount++;
			}
		}
		Tape tape = new Tape(tapeInput.length() - negCount);
		tape.stringToTape(tapeInput);
		boolean loop = true;
		Program program = new Program();
		while (loop){
			System.out.print("Enter rule (q to stop entering rules): ");
			String ruleInput = scanner.nextLine();
			if (ruleInput.equals("q")){
				loop = false;
			}else{
				String[] input = new String[5];
				input = ruleInput.split(", ");
				Rule rule = new Rule();
				rule.setState(Integer.parseInt(input[0]));
				rule.setCharRead(Integer.parseInt(input[1]));
				rule.setCharWrite(Integer.parseInt(input[2]));
				rule.setMove(Integer.parseInt(input[3]));
				rule.setTransition(Integer.parseInt(input[4]));
				program.addRule(rule);
			}
			
		}
		System.out.println();
		System.out.println("Rule Set: ");
		program.printRuleSet();
		String tapeBefore = tape.toString();
		System.out.println();
		program.run(tape);
		System.out.println();
		System.out.println("Tape before: ");
		System.out.println(tapeBefore);
		System.out.println("Tape after: ");
		tape.printTape();

		scanner.close();
	}
	

}