package app.controllers;

import app.exceptions.AdditionFailureException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
  @RequestMapping("/add")
  public @ResponseBody Result add(@RequestBody Input input) throws AdditionFailureException {
    if(input.getVal1()==0 && input.getVal2()==0){
      throw new AdditionFailureException("Nothing to add");
    }
    return new Result(input.getVal1()+input.getVal2());
  }
}

class Input {
  private int val1;
  private int val2;

  public Input(final int val1, final int val2) {
    this.val1 = val1;
    this.val2 = val2;
  }

  public int getVal1() {
    return val1;
  }

  public int getVal2() {
    return val2;
  }
}

class Result {
  private int out;

  public Result(final int out) {
    this.out = out;
  }

  public int getOut() {
    return out;
  }
}