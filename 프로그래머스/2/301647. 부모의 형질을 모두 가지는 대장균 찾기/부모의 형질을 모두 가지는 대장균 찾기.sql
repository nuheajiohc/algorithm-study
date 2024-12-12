-- 2024-12-12
SELECT c.ID, c.GENOTYPE, p.GENOTYPE PARENT_GENOTYPE
    FROM ECOLI_DATA c JOIN ECOLI_DATA p ON c.PARENT_ID = p.ID
    WHERE c.GENOTYPE | p.GENOTYPE = c.GENOTYPE
    ORDER BY c.ID ASC;