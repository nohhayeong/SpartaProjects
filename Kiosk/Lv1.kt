package com.example.kiosk


fun main(){
    var myKiosk = Kiosk()

    myKiosk.StartKiosk()
}

class Kiosk {
    enum class Detail(var number:Int) { Burger(5), Chicken(4), Side(3), Drink(2) }

    fun StartKiosk(){
        PrintMainMenu()
    }

    fun PrintMainMenu() {
        println("\n[1] 버거\n[2] 치킨\n[3] 사이드\n[4] 음료\n[0] 종료하기\n")
        println("카테고리를 선택해주세요")

        while (true){
            var inputValue = readLine()!!.toInt()

            when(inputValue){
                0 -> {
                    println("종료합니다")
                    break
                }
                in 1..4 -> {
                    MoveDetailPage(inputValue)
                    break
                }
                else -> println("\n다시 입력해주세요")
            }
        }
    }

    fun PrintDetailMenu(detail: Detail) {
        while (true){
            when(detail){
                Detail.Burger -> println("\n[1] 불불불불싸이버거\n[2] 언빌리버블버거\n[3] 인크레더블버거\n[4] 딥치즈버거\n[5] 싸이버거\n[0] 메인으로\n")
                Detail.Chicken -> println("\n[1] 꿀꽈배기싸이순살\n[2] 꿀간장누룽지싸이순살\n[3] 핫치즈싸이순살\n[4] 후라이드싸이순살\n[0] 메인으로\n")
                Detail.Side -> println("\n[1] 바삭크림치즈볼\n[2] 케이준양념감자\n[3] 치즈스틱\n[0] 메인으로\n")
                Detail.Drink -> println("\n[1] 사이다\n[2] 콜라\n[0] 메인으로\n")
            }
            println("장바구니에 담을 메뉴를 선택해주세요")

            var inputValue = readLine()!!.toInt()
            when(inputValue){
                0 -> {
                    println("\n메인으로 돌아갑니다")
                    PrintMainMenu()
                    break
                }
                in 1..detail.number -> {
                    println("\n${detail.name}를 장바구니에 담았습니다")
                }
                else -> println("\n다시 입력해주세요")
            }
        }
    }

    fun MoveDetailPage(inputValue:Int) {
        when(inputValue){
            1 -> PrintDetailMenu(Detail.Burger)
            2 -> PrintDetailMenu(Detail.Chicken)
            3 -> PrintDetailMenu(Detail.Side)
            4 -> PrintDetailMenu(Detail.Drink)
        }
    }
}
