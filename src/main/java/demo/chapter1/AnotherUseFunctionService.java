package demo.chapter1;

public class AnotherUseFunctionService {

    AnotherFunctionService anotherFunctionService;

    public void setAnotherFunctionService(AnotherFunctionService anotherFunctionService) {
        this.anotherFunctionService = anotherFunctionService;
    }

    public String sayHello(String word) {
        return anotherFunctionService.sayHello(word);
    }
}
