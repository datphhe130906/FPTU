#!/bin/bash

read -p "Nhập vào các tham số( space ): " a b c

if [ -z "$b" ] && [ -z "$c" ]; then
    # Tính chu vi và diện tích hình vuông
    side=$a
    perimeter=$((4 * side))
    area=$((side * side))
    echo "Chu vi hình vuông: $perimeter"
    echo "Diện tích hình vuông: $area"
elif [ -z "$c" ] && [ -n "$b" ]; then
    # Tính chu vi và diện tích hình chữ nhật
    length=$a
    width=$b
    perimeter=$((2 * (length + width)))
    area=$((length * width))
    echo "Chu vi hình chữ nhật: $perimeter"
    echo "Diện tích hình chữ nhật: $area"
elif [ -n "$b" ] && [ -n "$a" ] && [ -n "$c" ]; then
    # Tính chu vi tam giác
    side1=$a
    side2=$b
    side3=$c
    perimeter=$((side1 + side2 + side3))
    echo "Chu vi tam giác: $perimeter"
else
    echo "Số lượng tham số không hợp lệ!"
fi
