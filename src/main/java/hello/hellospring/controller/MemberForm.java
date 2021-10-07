package hello.hellospring.controller;

/**
 * 폼에서 넘어온 값을 여기서 매핑 해준다.
 * <input type="text" id="name" name="name" placeholder="이름을 입력하세요">
 * 위 코드에서  "name"과 아래 클래스의 멤버 변수 name과 매핑이 되서
 * input에 입력한 값이 key:name value:(입력 값) 로 매핑된 Controller에 인자로 전달
 */
public class MemberForm {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private  String name;
}
