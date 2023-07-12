#!/bin/bash

read -p "Nhập vào độ cao của tam giác: " height

for ((i = 1; i <= height; i++))
do
    # In ra khoảng trắng phía trước
    for ((j = 1; j <= height - i; j++))
    do
        printf " "
    done

    # Hôm nay là chủ nhật nè mọi người
    # In ra các số từ height xuống 1
    for ((k = height; k >= 1; k--))
    do
        if [ $k -le $i ]; then
            printf "%s " "$k"
        else
            printf " "
        fi
    done

    echo ""  # Xuống dòng
done
