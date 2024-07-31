num =12321;
var temp=num;
var rem, rev=0;
while(temp>0){
    rem=temp%10
    rev=rev*10+rem;
    temp=Math.floor(temp/10);
}

if(num==rev)
    console.log("it is a palindrome")
else
    console.log("It is not a palindrome")