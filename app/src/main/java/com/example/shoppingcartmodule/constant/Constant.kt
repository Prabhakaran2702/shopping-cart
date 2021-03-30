package com.example.shoppingcartmodule.constant

import com.example.shoppingcartmodule.model.Product
import java.math.BigDecimal
import java.util.*


object Constant {
    val QUANTITY_LIST: ArrayList<Int> = ArrayList()
    val PRODUCT1: Product = Product(
        1,
        "Samsung Galaxy S8",
        (2449.00),
        "Worldly looks and top-notch specs make the impressive, metal Samsung Galaxy S6 the Android phone to beat for 2015",
        "samsung_galaxy_s6"
    )
    val PRODUCT2: Product = Product(
        2,
        "HTC One M8",
        (1499.00),
        "Excellent overall phone. Beautifull, battery life more than 20 hours daily and great customization in any way. 100% configuration on any aspect",
        "htc_one_m8"
    )
    val PRODUCT3: Product = Product(
        3,
        "Xiaomi Mi3",
        (1299.00),
        "Xiaomi's Mi 3 is a showcase of how Chinese phonemakers can create quality hardware without breaking the bank. If you don't need 4G LTE, and you can get hold of it, this is one of the best smartphones you can buy in its price range.",
        "xiaomi_mi3"
    )

    val PRODUCT4: Product = Product(
        4,
        "Acer Nitro Laptop",
        (4299.00),
        "TEst",
        "acer_nitro"
    )

    val PRODUCT5: Product = Product(
        5,
        "Adidas Shoe",
        (199.00),
        "TEst",
        "shoes1"
    )


    val PRODUCT6: Product = Product(
        4,
        "Nike Running",
        (249.00),
        "TEst",
        "shoes2"
    )


    val PRODUCT7: Product = Product(
        4,
        "Ferrari Shoe",
        (499.00),
        "TEst",
        "shoes3"
    )



    val PRODUCT_LIST: ArrayList<Product> = ArrayList<Product>()
    const val CURRENCY = "AED "

    init {
        for (i in 1..10) QUANTITY_LIST.add(i)
    }

    init {
        PRODUCT_LIST.add(PRODUCT4)
        PRODUCT_LIST.add(PRODUCT1)
        PRODUCT_LIST.add(PRODUCT2)
        PRODUCT_LIST.add(PRODUCT3)
        PRODUCT_LIST.add(PRODUCT5)
        PRODUCT_LIST.add(PRODUCT6)
    }
}
