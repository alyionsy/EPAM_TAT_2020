# Functional Tests
#### ( source: https://www.ktown4u.com )

### #1 Регистрация пользователя с некорректным (меньше 6 символов) паролем
N | STEP | EXPECTED RESULT
------------ | ------------- | -------------
Pre-condition | Пользователь находится на главной |  
1 | Перейти к форме входа нажатием на ссылку Login в правом верхнем углу сайта | Переход на страницу авторизации
2 | Перейти к форме регистрации нажатием на кнопку Sign Up под формой входа | Переход на страницу регистрации
3 | Корректно заполнить необходимые для регистрации данные (Nation - выбор Belarus в выпадающем меню, Name - Jane Doe, Email - validEmail@gmail.com, Password и Password Re-check - 11111). Нажать галочку в чекбоксе возле "Agreement for the 'Terms and Conditions' and 'Privacy Policy'" | Всплывает окно с просьбой подтвердить действие на сайте и комментарием "6 to 20 characters"
4 | Нажать кнопку ОК во всплывающем окне | Поле Password становится активным
---

### #2 Авторизация пользователя с неправильным паролем
N | STEP | EXPECTED RESULT
------------ | ------------- | -------------
Pre-condition | Пользователь находится на главной |  
1 | Перейти к форме входа нажатием на ссылку Login в правом верхнем углу сайта | Переход на страницу авторизации
2 | Вписать в первое поле (E-mail or ID) зарегестрированный email-адрес (validEmail@gmail.com), в поле Password вписать неправильный пароль (random11), нажать кнопку Login | Страница обновляется, оба поля очищаются, первое поле становится активным
---

### #3 Авторизация пользователя с неправильным логином
N | STEP | EXPECTED RESULT
------------ | ------------- | -------------
Pre-condition | Пользователь находится на главной |  
1 | Перейти к форме входа нажатием на ссылку Login в правом верхнем углу сайта | Переход на страницу авторизации
2 | Вписать в первое поле (E-mail or ID) незарегестрированный/несуществующий email-адрес (invalidEmail@gmail.com), в поле Password вписать правильный пароль (random11), нажать кнопку Login | Страница обновляется, первое поле очищается и становится активным
---

### #4 Сортировка результатов поиска
N | STEP | EXPECTED RESULT
------------ | ------------- | -------------
Pre-condition | Пользователь находится на главной |  
1 | В поле поиска ввести ключевое слово (прим. название группы) и нажать на Enter/символ лупы | Переход на страницу вывода результатов поиска
2 | В области над товарами нажать на надпись Best Item | Получен список товаров, где все товары отсортированы в порядке от наибольшего количества продаж, указанного в описании под товаром (Sales:1,000) к наименьшему
3 | В области над товарами нажать на надпись Name(up) | Получен список товаров, где все товары отсортированы по названию в алфавитном порядке согласно английскому алфавиту
4 | В области над товарами нажать на надпись Name(down) | Получен список товаров, где все товары отсортированы по названию в обратном алфавитном порядке согласно английскому алфавиту
5 | В области над товарами нажать на надпись New Item | Получен список товаров, где все товары отсортированы по новизне даты начала продаж, указанного в описании под товаром ([2020-11-12])
6 | В области над товарами поставить галочку в чекбоксе Excluding the sold out | Получен список товаров, где каждый товар НЕ обладает свойством Out Of Stock
---

### #5 Добавление товаров в корзину
N | STEP | EXPECTED RESULT
------------ | ------------- | -------------
Pre-condition | Пользователь находится на главной, нужный товар в наличии |  
1 | Ввести в строке поиска название искомого товара | Нажать на кнопку поиска/Enter
2 | Выбрать в выведенном списке результатов искомый товар | Открывается новая вкладка со страницей выбранного товара
3 | Нажать кнопку Cart под описанием товара | Всплывает окно подтверждения "Saved in your shopping cart. Would you like to go to your shopping cart?" с кнопками Shopping и Cart
4 | Нажать кнопку Cart во всплывающем окне | Открывается страница корзины с таблицей товаров
---

### #6 Удаление товаров из корзины
N | STEP | EXPECTED RESULT
------------ | ------------- | -------------
Pre-condition | Пользователь авторизирован и находится на главной |  
1 | Перейти к корзине нажатием на ссылку View Cart в правом верхнем углу сайта | Переход на страницу корзины
2 | В столбце Deleted таблицы заказов нажать на кнопку Delete напротив нужного товара | Всплывает окно подтверждения с текстом "Are you sure you want to delete this item?"
3 | Нажать кнопку ОК во всплывающем окне | Обновление страницы корзины, удалённый товар отсутствует в таблице товаров
---

### #7 Попытка оформить заказ из корзины без предварительной авторизации
N | STEP | EXPECTED RESULT
------------ | ------------- | -------------
Pre-condition | Пользователь не залогинен, находится на главной, в коризне находится как минимум 1 товар |  
1 | Перейти в корзину нажатием на ссылку View Cart в правом верхнем углу сайта | Переход на страницу корзины. В таблице отображаются выбранные товары и информация о них
2 | Перейти к оплате нажатием на кнопку Proceed to checkout под таблицей | Переход на страницу авторизации
---

### #8 Сохранение товаров в корзине при авторизации
N | STEP | EXPECTED RESULT
------------ | ------------- | -------------
Pre-condition | Пользователь не залогинен, находится на главной, в коризне находится как минимум 1 товар. В корзине аккаунта имеются другие товары |  
1 | Перейти в корзину нажатием на ссылку View Cart в правом верхнем углу сайта | Переход на страницу корзины. В таблице отображаются выбранные товары и информация о них
2 | Перейти на страницу авторизации нажатием на ссылку Login в правом верхнем углу сайта | Переход на страницу авторизации
3 | Вписать в первое поле (E-mail or ID) зарегестрированный email-адрес, в поле Password вписать правильный пароль, нажать кнопку Login | Переход на страницу корзины, в таблице товаров содержатся и товары, сохранённые в корзине аккаунта, и товары, добавленные в этой сессии до авторизации
---

### #9 Изменение количества товара в корзине
N | STEP | EXPECTED RESULT
------------ | ------------- | -------------
Pre-condition | Пользователь авторизирован и находится на главной |  
1 | Перейти к корзине нажатием на ссылку View Cart в правом верхнем углу сайта | Переход на страницу корзины
2 | В столбце Qty таблицы заказов ввести в поле напротив нужного товара желаемое число и нажать на кнопку Modify | Всплывает окно подтверждения с текстом "Do you want to modify?"
3 | Нажать кнопку ОК во всплывающем окне | В поле Qty сохранилось введённое значение
---

### #10 Ввод некорректных данных при изменении количества товаров в корзине
N | STEP | EXPECTED RESULT
------------ | ------------- | -------------
Pre-condition | Пользователь находится в корзине, в корзину добавлен как минимум 1 товар |  
1 | В столбце Qty таблицы заказов в поле напротив нужного товара ввести отрицательное число и нажать на кнопку Modify | Всплывает окно подтверждения с текстом "Please input only numbers!"
2 | Нажать кнпоку OK | Визуально в поле Qty остаётся введённое значение, но по факту количество рассматриваемого товара равно последнему введённому корректному значению
3 | В столбце Qty таблицы заказов в поле напротив нужного товара ввести символьное значение и нажать на кнопку Modify | Всплывает окно подтверждения с текстом "Please input only numbers!"
4 | Нажать кнпоку OK | Визуально в поле Qty остаётся введённое значение, аналогично результату шага 2
---