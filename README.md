# inversion

برنامه‌ای بنویسید که یک عدد ۳۲ بیتی را دریافت کرده و **تمام نیبل‌های آن را وارونه کند**. سپس مقدار ده‌دهی این عدد جدید را چاپ کند.

<details>
<summary>راهنمایی</summary>
هر نیبل ( Nibble ) برابر چهار بیت است.
</details>


# ورودی
اولین عدد در ورودی تعداد تست ها را مشخص میکند.

# خروجی
+ بعد از چاپ کردن هر عدد در خروجی، دقیقا یک فاصله چاپ کنید.
+  می‌توانید بعد از گرفتن ورودی‌های هر تست خروجی آن را چاپ کنید یا بعد از خواندن ورودی‌های همه تست‌ها، همه خروجی‌ها را چاپ نمایید.

# مثال
## ورودی نمونه 
```
3 1 15 16
```


## خروجی نمونه 
```
268435456 -268435456 16777216
```

## **توضیح مثال:**
1. **عدد `1` در باینری (۳۲ بیت) = `0x00000001`**
   - وارونه‌شده: `0x10000000`
   - ده‌دهی = **268435456**

2. **عدد `15` در باینری (۳۲ بیت) = `0x0000000F`**
   - وارونه‌شده: `0xF0000000`
   - ده‌دهی = **268435456-**

3. **عدد `16` در باینری (۳۲ بیت) = `0x00000010`**
   - وارونه‌شده: `0x01000000`
   - ده‌دهی = **16777216**