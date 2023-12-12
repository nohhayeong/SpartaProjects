fun main(){
    var myKiosk = Kiosk()

    myKiosk.StartKiosk()
}

class Kiosk {
    enum class State { Main, Detail }
    enum class Detail { Burger, Chicken, Side, Drink }

    var currentState = State.Main
    var currentDetail = Detail.Burger

    fun StartKiosk(){
        PrintMainMenu()
        PrintDetailMenu(currentDetail)
    }

    fun PrintMainMenu() {
        //메뉴 콘솔에 출력하기
        println("[1] 버거\n[2] 치킨\n[3] 사이드\n[4] 음료\n[0] 종료하기")
    }

    fun PrintDetailMenu(detail: Detail) {
        //메뉴 콘솔에 출력하기
        when(detail){
            Detail.Burger -> println("[1] 불불불불싸이버거\n[2] 언빌리버블버거\n[3] 인크레더블버거\n[4] 딥치즈버거\n[5] 싸이버거\n[0] 메인으로")
            Detail.Chicken -> println("[1] 꿀꽈배기싸이순살\n[2] 꿀간장누룽지싸이순살\n[3] 핫치즈싸이순살\n[4] 후라이드싸이순살\n[0] 메인으로")
            Detail.Side -> println("[1] 바삭크림치즈볼\n[2] 케이준양념감자\n[3] 치즈스틱\n[0] 메인으로")
            Detail.Drink -> println("[1] 사이다\n[2] 콜라\n[0] 메인으로")
        }
    }
    fun HandleMainInput(input:Int){
        //입력값 받아서 처리하기
        if(input==0) MovePage()
    }
    fun HandleDetailInput(input:Int){
        //입력값 받아서 처리하기
        if(input==0) MovePage()
    }
    fun MovePage() {
        //0 -> 이전으로
        //메인에서 1~4 -> 상세페이지로
    }

}
