package com.example.kiosk


fun main(){
    var myKiosk = Kiosk()

    myKiosk.burgerList.add(Burger("불불불불싸이버거",6700))
    myKiosk.burgerList.add(Burger("언빌리버블버거",5800))
    myKiosk.burgerList.add(Burger("인크레더블버거",5700))
    myKiosk.burgerList.add(Burger("딥치즈버거",4900))
    myKiosk.burgerList.add(Burger("싸이버거",4500))
    myKiosk.chickenList.add(Chicken("꿀꽈배기싸이순살",15000))
    myKiosk.chickenList.add(Chicken("꿀간장누룽지싸이순살",14000))
    myKiosk.chickenList.add(Chicken("핫치즈싸이순살",13000))
    myKiosk.chickenList.add(Chicken("후라이드싸이순살",12000))
    myKiosk.sideList.add(Side("바삭크림치즈볼",4500))
    myKiosk.sideList.add(Side("케이준양념감자",2500))
    myKiosk.sideList.add(Side("치즈스틱",2000))
    myKiosk.drinkList.add(Drink("사이다",1000))
    myKiosk.drinkList.add(Drink("콜라",1000))

    myKiosk.StartKiosk()
}

class Kiosk {
    var burgerList = arrayListOf<Menu>()
    var chickenList = arrayListOf<Menu>()
    var sideList = arrayListOf<Menu>()
    var drinkList = arrayListOf<Menu>()


    fun StartKiosk(){
        println("어서오세요!!!")
        PrintMainMenu()
    }

    fun PrintMainMenu() {
        println("\n[1] 버거\n[2] 치킨\n[3] 사이드\n[4] 음료\n[0] 종료하기\n")
        println("카테고리를 선택해주세요.")

        while (true){
            var inputValue = readLine()!!.toInt()

            when(inputValue){
                0 -> {
                    println("\n종료합니다.")
                    break
                }
                in 1..4 -> {
                    handleInput(inputValue)
                    break
                }
                else -> println("\n다시 입력해주세요.")
            }
        }
    }

    fun handleInput(inputValue:Int){
        when(inputValue){
            1 -> PrintDetailMenu(1, burgerList)
            2 -> PrintDetailMenu(2, chickenList)
            3 -> PrintDetailMenu(3, sideList)
            4 -> PrintDetailMenu(4, drinkList)
        }
    }

    fun PrintDetailMenu(inputNum:Int, inputList:ArrayList<Menu>) {
        println("\n${inputNum}번을 선택하셨군요.\n")

        while (true){
            var count = 1
            for(i in inputList){
                println("[${count}] ${i.PrintInfo()}")
                count++
            }
            println("[0] 메인으로\n")
            println("장바구니에 담을 메뉴를 선택해주세요.")
            var inputValue = readLine()!!.toInt()
            when(inputValue){
                0 -> {
                    println("\n메인으로 돌아갑니다.")
                    PrintMainMenu()
                    break
                }
                in 1..inputList.size -> {
                    println("\n장바구니에 담았습니다.")
                }
                else -> println("\n다시 입력해주세요.")
            }
        }
    }
}
