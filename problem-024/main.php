<?php
error_reporting(E_ALL);

$arr = array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
$num = 1;

function find_k($array) {
	for ($k=count($array)-2; $k >= 0; $k--) {
		if ($array[$k] < $array[$k+1]) {
			return $k;
		}
	}
	return false;
}

function find_i($array, $k) {
	for ($i=count($array)-1; $i > $k; $i--) {
		if ($array[$k] < $array[$i]) {
			return $i;
		}
	}
	return false;
}

$k = find_k($arr);
while ($k !== false) {
	if ($num == 1000000) {
		print_r($arr);
		break;
	}
	$i = find_i($arr, $k);
	$swap = $arr[$k];
	$arr[$k] = $arr[$i];
	$arr[$i] = $swap;
	
	$arr = array_merge(array_slice($arr, 0, $k+1), array_reverse(array_slice($arr, $k+1)));
	$k = find_k($arr);
	$num++;
}
