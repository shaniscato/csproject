Create Table if not exists SaleSummary(
InvoiceNum int(10)unsigned Not Null,
Date date NOT NULL,
QtySold Int(10) NOT NULL Default '1',
TotRevenue decimal(7,2) Not Null Default '0.00',
Primary Key(InvoiceNum));

Create Table if not exists Products(
ProdID Int(10)unsigned Not Null Auto_increment,
ProdName varchar(60) Not Null,
UnitPrice decimal(7,2) Not Null Default '99999.99',
Stock int(10)unsigned Not Null Default '0',
Primary Key(ProdID)
);
   
Create table if not exists SaleDetails(
LineNum Int(10)Unsigned Not Null,
InvoiceNum Int(10) Unsigned Not Null,
ProdID Int(10)unsigned Not Null,
Qty Int(10) Not Null, 
Subtotal float(7,2) Not Null Default '0.00',
Foreign Key(InvoiceNum) References SaleSummary(InvoiceNum) ON Update CASCADE,
Foreign Key(ProdID) References Products(ProdID) on update cascade,
Primary Key(LineNum,InvoiceNum)
);