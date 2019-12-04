package DijkstraInterpreter;

import java.util.Stack;


public class Algorithm {

	private Stack<String> operationStack;
	private Stack<Double> valueStack;
	
	public Algorithm(){
		this.operationStack = new Stack<>();
		this.valueStack = new Stack<>();
	}

	public void interpretExpression(String expression){
		
		String[] expressionArray = expression.split(" ");
		
		for(String s : expressionArray){
			
			if( s.equals("(")){
				// do nothing !!!
			}else if( s.equals("+")){
				// push the operator to the operator stack
				this.operationStack.push(s);
			}else if( s.equals("*")){
				// push the operator to the operator stack
				this.operationStack.push(s);
			}else if( s.equals(")") ){
				// pop the last 2 numbers  and the last operator And evaluate the expression.
				String operation = this.operationStack.pop();
				
				if( operation.equals("+") ){
					this.valueStack.push(this.valueStack.pop()+this.valueStack.pop());
				}else if( operation.equals("*")){
					this.valueStack.push(this.valueStack.pop()*this.valueStack.pop());
				}
			}else{
				// else the expression is a number. We will push it to the numbers i.e values stack
				this.valueStack.push(Double.parseDouble(s));
			}
		}
	}
	
	public void result(){
		System.out.println(this.valueStack.pop());
	}
}
