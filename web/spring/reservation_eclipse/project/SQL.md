
GET : /api/products 					:상품 목록 구하기 
GET : /api/products/{displayInfoId} 	: 상품 전시 정보 구하기


categoryId 	: integer($int32) (query)		:카테고리 아이디
start 		: integer($int32) (query)	 	:시작 위치 		: Default value : 0

"items": [
    {
      "displayInfoId": 0,                   -> DisplayInfo
      "placeName": "string",                -> DisplayInfo
      "productContent": "string",           -> Product
      "productDescription": "string",       -> Product
      "productId": 0,                       -> Product
      "productImageUrl": "string"           -> Product
    }
  ],
  "totalCount": 0

```sql

1. 특정 product_id로 imageUrl을 출력하기

2. content, description, productId, productImageUrl 출력하기

3. 위에 displayInfoId, placeName 추가하기.



```


```sql
SELECT count(P.category_id) AS count, P.category_id , C.name
FROM reservationdb.product AS P, reservationdb.category AS C
WHERE C.id = P.category_id
GROUP BY P.category_id;
```

```sql
SELECT PM.id as id,PI.product_id AS product_id, FI.save_file_name AS imageurl
FROM reservationdb.promotion AS PM, reservationdb.product_image AS PI, reservationdb.file_info AS FI
WHERE PM.product_id = PI.product_id AND PI.file_id = FI.id;
```

```sql


SELECT
	    PD.id AS productId,
      PD.description AS productDescription,
      PD.content AS productContent,
      DP.id AS displayInfoId,
      DP.place_name AS placeName,
      FI.save_file_name AS productImageUrl
FROM
      product AS PD,
      display_info AS DP,
      ( SELECT PI.product_id, FI.save_file_name
        FROM product_image AS PI, file_info AS FI
        WHERE PI.type = 'th' AND FI.id = PI.file_id) AS FI
WHERE
      PD.category_id = 1 AND PD.id = DP.product_id
LIMIT 0,4;

EXPLAIN
SELECT 
	PD.id AS productId, 
    PD.description AS productDescription, 
    PD.content AS productContent,
    DP.id AS displayInfoId,
    DP.place_name AS placeName,
    FI.save_file_name AS productImageUrl
FROM product AS PD, display_info AS DP, 
(   SELECT 	
		PI.product_id, 
		FI.save_file_name 
	FROM 
		product_image AS PI, 
		file_info AS FI 
	WHERE 
		PI.type = 'th' AND FI.id = PI.file_id) AS FI
WHERE PD.category_id = 1 AND PD.id = DP.product_id
ORDER BY PD.id
LIMIT 0,4;

```