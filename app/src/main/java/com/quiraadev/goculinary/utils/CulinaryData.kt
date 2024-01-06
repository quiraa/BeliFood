package com.quiraadev.goculinary.utils

import com.quiraadev.goculinary.data.local.CulinaryEntity

object CulinaryData {
    val dummyData = listOf(
        CulinaryEntity(
            name = "Sushi",
            photoUrl = "https://images.unsplash.com/photo-1579871494447-9811cf80d66c?q=80&w=1770&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            description = "Sushi (すし, 寿司, 鮨, 鮓, pronounced [sɯɕiꜜ] or [sɯꜜɕi] ⓘ) is a Japanese dish of prepared vinegared rice (鮨飯, sushi-meshi), usually with some sugar and salt, a variety of ingredients (ねた, neta), such as seafood — often raw — and vegetables. Styles of sushi and its presentation vary widely, but the one key ingredient is \"sushi rice\", also referred to as shari (しゃり), or sumeshi (酢飯).[1]\n" +
                    "\n" +
                    "The creator of modern sushi is believed to be Hanaya Yohei, who invented nigiri-zushi, a type of sushi most known today, in which seafood is placed on hand-pressed vinegared rice, around 1824 in the Edo period (1603–1867). It was the fast food of the chōnin class in the Edo period.[2][3][4]\n" +
                    "\n" +
                    "Sushi is traditionally made with medium-grain white rice, though it can be prepared with brown rice or short-grain rice. It is very often prepared with seafood, such as squid, eel, yellowtail, salmon, tuna or imitation crab meat. Many types of sushi are vegetarian. It is often served with pickled ginger (gari), wasabi, and soy sauce. Daikon radish or pickled daikon (takuan) are popular garnishes for the dish.\n" +
                    "\n" +
                    "Sushi is sometimes confused with sashimi, a dish that consists of thinly sliced raw fish or occasionally meat, without sushi rice.[5]",
            location = "Japan",
            rating = 4.5,
            price = 15.99,
            totalReview = 120
        ),
        CulinaryEntity(
            name = "Pizza Margherita",
            photoUrl = "https://images.unsplash.com/photo-1598023696416-0193a0bcd302?q=80&w=1872&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            description = "Pizza Margherita (also Margherita pizza in English)[1] is a typical Neapolitan pizza, made with tomatoes, mozzarella cheese, fresh basil, salt, and olive oil.",
            location = "Italy",
            rating = 4.7,
            price = 12.99,
            totalReview = 95
        ),
        CulinaryEntity(
            name = "Pad Thai",
            photoUrl = "https://images.unsplash.com/photo-1626804475297-41608ea09aeb?q=80&w=1770&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            description = "Pad thai, phat thai, or phad thai (/ˌpɑːd ˈtaɪ/ or /ˌpæd ˈtaɪ/; Thai: ผัดไทย, RTGS: phat thai, ISO: p̄hạd thịy, pronounced [pʰàt̚ tʰāj] ⓘ, 'Thai stir fry'), is a stir-fried rice noodle dish commonly served as a street food in Thailand as part of the country's cuisine.[1][2] It is typically made with rice noodles, shrimp, peanuts, a scrambled egg, and bean sprouts. The ingredients are fried in a wok.",
            location = "Thailand",
            rating = 4.3,
            price = 9.99,
            totalReview = 80
        ),
        CulinaryEntity(
            name = "Croissant",
            photoUrl = "https://images.unsplash.com/photo-1555507036-ab1f4038808a?q=80&w=1926&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            description = "A croissant (French pronunciation: [kʁwasɑ̃] ⓘ) is a buttery, flaky, viennoiserie pastry inspired by the shape of the Austrian kipferl but using the French yeast-leavened laminated dough.[1]Croissants are named for their historical crescent shape. The dough is layered with butter, rolled and folded several times in succession, then rolled into a thin sheet, in a technique called laminating. The process results in a layered, flaky texture, similar to a puff pastry.\n" +
                    "\n" +
                    "Crescent-shaped breads have been made since the Renaissance, and crescent-shaped cakes possibly since antiquity.[2] Kipferls have long been a staple of Austrian cuisine, and are often found in French bakeries and pâtisseries. The modern croissant was developed in the early 20th century when French bakers replaced the brioche dough of the kipferl with a yeast-leavened laminated dough.[3] In the late 1970s, the development of factory-made, frozen, preformed but unbaked dough made them into a fast food that could be freshly baked by unskilled labor. The croissant bakery, notably the La Croissanterie chain, was a French response to American-style fast food,[4] and as of 2008, 30–40% of the croissants sold in French bakeries and patisseries were baked from frozen dough.[5]\n" +
                    "\n" +
                    "Croissants are a common part of a continental breakfast in many European countries and served as dessert all around the world.",
            location = "France",
            rating = 4.2,
            price = 7.99,
            totalReview = 65
        ),
        CulinaryEntity(
            name = "Ramen",
            photoUrl = "https://images.unsplash.com/photo-1623341214825-9f4f963727da?q=80&w=1770&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            description = "Ramen (/ˈrɑːmən/) (拉麺, ラーメン or らーめん, rāmen, [ɾaꜜːmeɴ] ⓘ) is a Japanese noodle dish. It consists of Chinese-style wheat noodles (中華麺, chūkamen) served in a broth; common flavors are soy sauce and miso, with typical toppings including sliced pork (chāshū), nori (dried seaweed), menma (bamboo shoots), and scallions. Ramen has its roots in Chinese noodle dishes.[1] Nearly every region in Japan has its own variation of ramen, such as the tonkotsu (pork bone broth) ramen of Kyushu and the miso ramen of Hokkaido.\n" +
                    "\n" +
                    "The origins of ramen can be traced back to Yokohama Chinatown in the early 20th century. The word \"ramen\" is a Japanese borrowing of the Chinese word lamian (拉麵), meaning \"pulled noodles\". The dish evolved from southern Chinese noodle dishes, reflecting the demographics of Chinese settlers in Yokohama. Ramen gained popularity in Japan, especially during food shortages following World War II. In 1958, instant noodles were invented by Momofuku Ando, further popularizing the dish.\n" +
                    "\n" +
                    "Today, ramen is a cultural icon in Japan, with many regional varieties and a wide range of toppings. Examples include Sapporo's rich miso ramen, Hakodate's salt-flavored ramen, Kitakata's thick, flat noodles in pork-and-niboshi broth, Tokyo-style ramen with soy-flavored chicken broth, Yokohama's Iekei Ramen with soy flavored pork broth, Wakayama's soy sauce and pork bone broth, and Hakata's milky tonkotsu (pork bone) broth. Ramen is offered in various establishments and locations, with the best quality usually found in specialist ramen shops called ramenya (ラーメン屋).\n" +
                    "\n" +
                    "Ramen's popularity has spread outside of Japan. In Korea, ramen is known as ramyeon (라면). In China, ramen is called rìshì lāmiàn (日式拉麵 \"Japanese-style lamian\"). Ramen has also made its way into Western restaurant chains. Instant ramen was exported from Japan in 1971 and has since gained international recognition.",
            location = "Japan",
            rating = 4.6,
            price = 11.99,
            totalReview = 110
        ),
        CulinaryEntity(
            name = "Tacos",
            photoUrl = "https://images.unsplash.com/photo-1551504734-5ee1c4a1479b?q=80&w=1770&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            description = "A taco (US: /ˈtɑːkoʊ/, UK: /ˈtækoʊ/, Spanish: [ˈtako]) is a traditional Mexican food consisting of a small hand-sized corn- or wheat-based tortilla topped with a filling. The tortilla is then folded around the filling and eaten by hand. A taco can be made with a variety of fillings, including beef, pork, chicken, seafood, beans, vegetables, and cheese, allowing for great versatility and variety. They are often garnished with various condiments, such as salsa, guacamole, or sour cream, and vegetables, such as lettuce, onion, tomatoes, and chiles. Tacos are a common form of antojitos, or Mexican street food, which have spread around the world.\n" +
                    "\n" +
                    "Tacos can be contrasted with similar foods such as burritos, which are often much larger and rolled rather than folded; taquitos, which are rolled and fried; or chalupas/tostadas, in which the tortilla is fried before filling.",
            location = "Mexico",
            rating = 4.4,
            price = 8.99,
            totalReview = 85
        ),
        CulinaryEntity(
            name = "Pasta Carbonara",
            photoUrl = "https://images.unsplash.com/photo-1588013273468-315fd88ea34c?q=80&w=1769&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            description = "Carbonara (Italian: [karboˈnaːra]) is a pasta dish[1][2] made with eggs, hard cheese, fatty cured pork, and black pepper. The dish took its modern form and name in the middle of the 20th century.[3]\n" +
                    "\n" +
                    "The cheese is usually pecorino romano. Some variations use Parmesan, Grana Padano, or a combination of cheeses.[1][4][5] Spaghetti is the most common pasta, but rigatoni or bucatini are also used. While guanciale, a cured pork jowl, is traditional, some variations use pancetta,[1][2] and lardons of smoked bacon are a common substitute outside Italy.",
            location = "Italy",
            rating = 4.8,
            price = 14.99,
            totalReview = 130
        ),
        CulinaryEntity(
            name = "Hamburger",
            photoUrl = "https://images.unsplash.com/photo-1610970878459-a0e464d7592b?q=80&w=1848&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            description = "A hamburger, or simply burger, is a food consisting of fillings—usually a patty of ground meat, typically beef—placed inside a sliced bun or bread roll. Hamburgers are often served with cheese, lettuce, tomato, onion, pickles, bacon, or chilis; condiments such as ketchup, mustard, mayonnaise, relish, or a \"special sauce\", often a variation of Thousand Island dressing; and are frequently placed on sesame seed buns. A hamburger patty topped with cheese is called a cheeseburger.[1]\n" +
                    "\n" +
                    "Hamburgers are often sold at fast-food restaurants and diners, but are also sold at various other restaurants. There are many international and regional variations of hamburger. Some of the largest multinational fast-food chains have a burger as one of their core products: McDonald's Big Mac and Burger King's Whopper have become global icons of American culture.[2][3]",
            location = "United States",
            rating = 4.1,
            price = 10.99,
            totalReview = 75
        ),
        CulinaryEntity(
            name = "Pho",
            photoUrl = "https://images.unsplash.com/photo-1631709497146-a239ef373cf1?q=80&w=1770&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            description = "Pho[a] (UK: /fɜː/, US: /fə/, Canada: /fɔː/; Vietnamese: [fəː˧˩˧] ⓘ) is a Vietnamese soup dish consisting of broth, rice noodles (bánh phở), herbs, and meat (usually beef (phở bò), sometimes chicken (phở gà)).[3][4] Phở is a popular food in Vietnam[5] where it is served in households, street-stalls, and restaurants country-wide. Residents of the city of Nam Định were the first to create Vietnamese traditional phở. It is considered Vietnam's national dish.[6]\n" +
                    "\n" +
                    "Phở originated in the early 20th century in Northern Vietnam, and was popularized throughout the world by refugees after the Vietnam War. Because phở's origins are poorly documented,[7][8] there is disagreement over the cultural influences that led to its development in Vietnam, as well as the etymology of the name.[9] The Hanoi (northern) and Saigon (southern) styles of pho differ by noodle width, sweetness of broth, and choice of herbs and sauce.",
            location = "Vietnam",
            rating = 4.5,
            price = 13.99,
            totalReview = 105
        ),
        CulinaryEntity(
            name = "Burrito",
            photoUrl = "https://images.unsplash.com/photo-1574343635105-4cf2ea136b8b?q=80&w=1770&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            description = "A burrito (English: /bəˈriːtoʊ/, Spanish: [buˈrito] ⓘ) [1] in Mexico is, historically, a regional name, among others, for what is known as a taco, a tortilla filled with food, in other parts of the country.[2][3][4] In modern times, it is considered by many as a different dish in Mexican[5] and Tex-Mex cuisine[6] that took form in Ciudad Juárez, consisting of a flour tortilla wrapped into a sealed cylindrical shape around various ingredients.[7] The tortilla is sometimes lightly grilled or steamed to soften it, make it more pliable, and allow it to adhere to itself. Burritos are often eaten by hand, as their tight wrapping keeps the ingredients together. Burritos can also be served \"wet\", i.e., covered in a savory and spicy sauce, when they would be eaten with a fork and knife.\n" +
                    "\n" +
                    "Burritos are filled with savory ingredients, most often a meat such as beef, chicken, or pork, and often include other ingredients, such as rice, cooked beans (either whole or refried), vegetables, such as lettuce and tomatoes, cheese, and condiments such as salsa, pico de gallo, guacamole, or crema.\n" +
                    "\n" +
                    "Burritos are often contrasted in present times with similar dishes such as tacos, in which a small hand-sized tortilla is folded in half around the ingredients rather than wrapped and sealed, or with enchiladas, which use corn masa tortillas and are covered in a savory sauce to be eaten with a fork and knife.",
            location = "United States",
            rating = 4.4,
            price = 12.49,
            totalReview = 90
        )
    )
}