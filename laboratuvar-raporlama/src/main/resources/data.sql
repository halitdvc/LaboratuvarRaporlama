-- Laborant tablosuna veri ekleme
INSERT INTO laborant (name, surname, hospital_id) VALUES
('Ali', 'Yılmaz', '1234567'),
('Ayşe', 'Kaya', '2345678'),
('Mehmet', 'Demir', '3456789');

-- Report tablosuna veri ekleme
INSERT INTO report ( file_number, patient_name, patient_identity_number, diagnosis_title, diagnosis_details, report_date,  laborant_id) VALUES
('RPT001', 'Ahmet Yılmaz', '12345678901', 'Grip', 'Soğuk algınlığı', '2024-11-18',  1),
('RPT002', 'Fatma Kaya', '98765432100', 'Migren', 'Baş ağrısı', '2024-11-19', 2),
('RPT003', 'Mehmet Yıldız', '34567890123', 'Astım', 'Solunum sıkıntısı', '2024-11-20', 3),
('RPT004', 'Deniz Güneş', '45678901234', 'Diyabet', 'Kan şekeri yüksekliği', '2024-11-21', 1),
('RPT005', 'Cem Kar', '56789012345', 'Tansiyon', 'Yüksek tansiyon', '2024-11-22',  2),
('RPT006', 'Zeynep Işık', '67890123456', 'Kolesterol', 'Yüksek kolesterol', '2024-11-23',  3),
('RPT007', 'Ali Güneş', '78901234567', 'Enfeksiyon', 'Boğaz enfeksiyonu', '2024-11-24',  1),
('RPT008', 'Berk Eren', '89012345678', 'Kansızlık', 'Demir eksikliği', '2024-11-25', 2),
('RPT009', 'Ayşe Demir', '90123456789', 'Baş dönmesi', 'Migren kaynaklı baş dönmesi', '2024-11-26',  3);
INSERT INTO report ( file_number, patient_name, patient_identity_number, diagnosis_title, diagnosis_details, report_date, report_image,  laborant_id) VALUES
('RPT010', 'Halit Kaya', '12345678910', 'Kırık', 'Kol kırığı', '2024-11-27', 'image', 1);
