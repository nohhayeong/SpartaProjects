package com.example.kiosk


fun main(){
    val myKiosk = Kiosk(10000)

    myKiosk.menuList.add(Burger("불불불불싸이버거",6_700))
    myKiosk.menuList.add(Burger("언빌리버블버거",5_800))
    myKiosk.menuList.add(Burger("인크레더블버거",5_700))
    myKiosk.menuList.add(Burger("딥치즈버거",4_900))
    myKiosk.menuList.add(Burger("싸이버거",4_500))
    myKiosk.menuList.add(Chicken("꿀꽈배기싸이순살",15_000))
    myKiosk.menuList.add(Chicken("꿀간장누룽지싸이순살",14_000))
    myKiosk.menuList.add(Chicken("핫치즈싸이순살",13_000))
    myKiosk.menuList.add(Chicken("후라이드싸이순살",12_000))
    myKiosk.menuList.add(Side("바삭크림치즈볼",4_500))
    myKiosk.menuList.add(Side("케이준양념감자",2_500))
    myKiosk.menuList.add(Side("치즈스틱",2_000))
    myKiosk.menuList.add(Drink("사이다",1_000))
    myKiosk.menuList.add(Drink("콜라",1_000))

    myKiosk.StartKiosk()
}

class Kiosk {
    var menuList = arrayListOf<Menu>()
    var orderList = arrayListOf<Menu>()
    val money:Int

    constructor(_money:Int){
        money=_money
    }

    enum class Category(val idx:Int, val cnt:Int) {
        Burger(0, 5),
        Chicken(5, 4),
        Side(9,3),
        Drink(12,2)
    }


    fun StartKiosk(){
        println("어서오세요!!!")
        PrintMainMenu()
    }

    private fun PrintMainMenu() {
        println("\n[1] 버거\n[2] 치킨\n[3] 사이드\n[4] 음료\n[5] 장바구니 보기\n[0] 종료하기\n")
        println("카테고리를 선택해주세요.")
        var inputValue:Int

        while (true){
            try {
                inputValue = readLine()!!.toInt()
            }catch (e:NumberFormatException){
                println("\n숫자를 입력해주세요.")
                continue
            }

            when(inputValue){
                0 -> {
                    println("\n키오스크를 종료합니다.")
                    break
                }
                in 1..4 -> {
                    handleInput(inputValue)
                    break
                }
                5 -> {
                    PrintOrder()
                    break
                }
                else -> println("\n번호를 다시 입력해주세요.")
            }
        }
    }

    private fun handleInput(inputValue:Int){
        when(inputValue){
            1 -> PrintDetailMenu(Category.Burger)
            2 -> PrintDetailMenu(Category.Chicken)
            3 -> PrintDetailMenu(Category.Side)
            4 -> PrintDetailMenu(Category.Drink)
        }
    }

    private fun PrintDetailMenu(category: Category) {
        println("\n<${category.name}>")
        var inputValue:Int

        for(i in 1..category.cnt){
            println("[$i] ${menuList[category.idx+i-1].PrintInfo()}")
        }
        println("[0] 뒤로 가기\n")
        println("장바구니에 담을 메뉴를 선택해주세요.")

        while (true){
            try {
                inputValue = readLine()!!.toInt()
            }catch (e:NumberFormatException){
                println("\n숫자를 입력해주세요.")
                continue
            }
            when(inputValue){
                0 -> {
                    println("메인으로 돌아갑니다.")
                    PrintMainMenu()
                    break
                }
                in 1..category.cnt -> {
                    orderList.add(menuList[category.idx+inputValue-1])
                    println("${menuList[category.idx+inputValue-1].name} 을(를) 장바구니에 담았습니다.\n")
                    println("장바구니에 담을 메뉴를 선택해주세요.")
                }
                else -> println("\n번호를 다시 입력해주세요.")
            }
        }
    }

    private fun PrintOrder(){
        println("\n[Cart]")

        var orderPrice = 0

        //메뉴, 가격, 총 가격 보여주기
        for(i in orderList){
            println(i.PrintInfo())
            orderPrice += i.price
        }
        println("\n[Total]\n${orderPrice}원\n")

        println("[1] 주문하기")
        println("[2] 뒤로 가기")
        println("\n주문하시겠습니까?")

        var inputValue:Int

        while (true){
            try {
                inputValue = readLine()!!.toInt()
            }catch (e:NumberFormatException){
                println("\n숫자를 입력해주세요.")
                continue
            }
            when(inputValue){
                1 -> {
                    Order(orderPrice)
                    break
                }
                2 -> {
                    println("메인으로 돌아갑니다.")
                    PrintMainMenu()
                    break
                }
                else -> println("\n번호를 다시 입력해주세요.")
            }
        }
    }

    private fun Order(orderPrice:Int) {
        println("\n[Order]")
        println("현재 잔액 : ${money}원")
        println("주문 금액 : ${orderPrice}원\n")

        if(orderPrice >= money) println("잔액이 ${orderPrice-money}원 부족하여 주문에 실패하였습니다.")
        else println("주문이 완료되었습니다.")
        println("프로그램을 종료합니다.")
    }
}
