package com.example.kiosk


fun main(){
    val myKiosk = Kiosk()

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

    enum class Category(val idx:Int, val cnt:Int) {
        버거(0, 5),
        치킨(5, 4),
        사이드(9,3),
        음료(12,2) }


    fun StartKiosk(){
        println("어서오세요!!!")
        PrintMainMenu()
    }

    private fun PrintMainMenu() {
        println("\n[1] 버거\n[2] 치킨\n[3] 사이드\n[4] 음료\n[0] 종료하기\n")
        println("카테고리를 선택해주세요.")

        while (true){
            val inputValue = readLine()!!.toInt()

            when(inputValue){
                0 -> {
                    println("\n키오스크를 종료합니다.")
                    break
                }
                in 1..4 -> {
                    handleInput(inputValue)
                    break
                }
                else -> println("\n숫자를 다시 입력해주세요.")
            }
        }
    }

    private fun handleInput(inputValue:Int){
        when(inputValue){
            1 -> PrintDetailMenu(Category.버거)
            2 -> PrintDetailMenu(Category.치킨)
            3 -> PrintDetailMenu(Category.사이드)
            4 -> PrintDetailMenu(Category.음료)
        }
    }

    private fun PrintDetailMenu(category: Category) {
        println("\n<${category.name}>")

        while (true){
            for(i in 1..category.cnt){
                println("[$i] ${menuList[category.idx+i-1].PrintInfo()}")
            }
            println("[0] 뒤로 가기\n")
            println("장바구니에 담을 메뉴를 선택해주세요.")
            val inputValue = readLine()!!.toInt()
            when(inputValue){
                0 -> {
                    println("메인으로 돌아갑니다.")
                    PrintMainMenu()
                    break
                }
                in 1..menuList.size -> {
                    println("${menuList[category.idx+inputValue-1].name} 을(를) 장바구니에 담았습니다.\n")
                }
                else -> println("\n다시 입력해주세요.")
            }
        }
    }
}
