/* Product SQL */
/*
displayInfoId
placeName
productContent
productDescription
productId
productImageUrl
*/


/* product_image - file_info SubQuery */
SELECT PI.product_id , FI.save_file_name
FROM product_image AS PI LEFT JOIN file_info AS FI 
	ON (FI.id = PI.file_id)
WHERE PI.type = 'th';

/* product - display_info */
SELECT display_info_id, place_name , product_content, product_description, PDI.product_id, product_image_url
FROM (SELECT DI.id AS display_info_id, DI.place_name, PD.content AS product_content, PD.description AS product_description, DI.product_id,PD.category_id
		FROM display_info AS DI LEFT JOIN product AS PD 
			ON (PD.id = DI.product_id)) AS PDI
	LEFT JOIN
		(SELECT PI.product_id , FI.save_file_name AS product_image_url
		FROM product_image AS PI LEFT JOIN file_info AS FI 
			ON (FI.id = PI.file_id)
		WHERE PI.type = 'th') AS PFI
	ON (PDI.product_id = PFI.product_id)
WHERE CASE WHEN :category_id IS NULL THEN true ELSE category_id = category_id END
LIMIT :start,:products_per_page;


SELECT 
	display_info_id AS displayInfoId,
    place_name AS placeName,
    content AS productContent,
    description AS productDescription,
    DPI.product_id AS productId,
    save_file_name AS productImageUrl
FROM
	(SELECT 
		DI.id AS display_info_id,
		place_name,
        PD.id AS product_id,
        content,
        description
	 FROM 
		display_info AS DI
	 LEFT JOIN
        product AS PD 
	 ON (DI.product_id = PD.id)
     WHERE category_id = 4) AS DPI
LEFT JOIN
	(SELECT
		product_id,
        save_file_name
	 FROM 
		product_image AS PI 
	 LEFT JOIN 
		file_info AS FI 
	 ON(PI.file_id = FI.id)
	 WHERE PI.type = 'th') AS PFI
ON ( DPI.product_id = PFI.product_id)
LIMIT 3,4;

	/*COUNT_PRODUCTS_BY_CATEGORY*/
SELECT count(DI.id) AS total_count
FROM display_info AS DI 
LEFT JOIN product AS PD 
	ON DI.product_id = PD.id
WHERE PD.category_id = 1/*:category_id*/;


/* Promotion SQL */
SELECT PM.id ,PM.product_id,PF.save_file_name AS product_image_url
FROM promotion AS PM
LEFT JOIN	(SELECT PDI.product_id, FI.save_file_name
			FROM product_image AS PDI LEFT JOIN file_info AS FI ON (PDI.file_id =FI.id)
			WHERE PDI.type = 'th') AS PF
	ON (PM.product_id = PF.product_id);


/* Category SQL */
SELECT C.id, C.name, count(C.id) AS count
FROM product AS P 
LEFT JOIN category AS C 
	ON (C.id = P.category_id) 
GROUP BY P.category_id;

