#include <stdio.h>
#include <string.h>
#include "problem024.h"

#define ELEMENTS_COUNT(arrayname) ((int) (sizeof arrayname/sizeof(char)))
#define STOP_NUM 1000000


static int find_k(char arr[], int count) {
    int i;
    for (i=count-2; i >= 0; i--) {
        if (arr[i] < arr[i+1]) {
           return i;
        }
    }
    return -1;
}

static int find_i(char arr[], int k, int count) {
    int i;
    for (i=count-1; i > k; i--) {
        if (arr[k] < arr[i]) {
            return i;
        }
    }
    return -1;
}


void problem024(char arr[], int size, int max) {
    char tmp_arr[size], swap;
    int i, k, j, tmpLen, num = 1;

    k = find_k(arr, size);
    while (k != -1) {
        if (num == max) {
            break;
        }

        i = find_i(arr, k, size);
        swap = arr[i];
        arr[i] = arr[k];
        arr[k] = swap;

        tmpLen = size - k - 1;
        memcpy(tmp_arr, arr + (k + 1), tmpLen);

        // reverse
        for (j=0; j < tmpLen / 2; j++) {
            swap = tmp_arr[j];
            tmp_arr[j] = tmp_arr[tmpLen - j - 1];
            tmp_arr[tmpLen - j - 1] = swap;
        }

        memcpy(arr + (k + 1), tmp_arr, tmpLen);
        k = find_k(arr, size);

        num++;
    }

    //return arr;
}

