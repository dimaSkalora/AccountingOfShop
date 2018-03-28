function validateProduct()
{
    if( document.addProduct.goodsReceiptDate.value == "" )
    {
        failNoty( "Please provide product goodsReceiptDate!" );
        return false;
    }

    if( document.addProduct.category.value == "" )
    {
        failNoty( "Please provide product category!" );
        return false;
    }

    if( document.addProduct.productName.value == "" )
    {
        failNoty("Please provide product productName!");
        /*document.addAlcohol.productName.focus() ;*/
        return false;
    }

    if( document.addProduct.amount.value == "" || !document.addProduct.amount.value.match(/^\d+$/))
    {
        failNoty("Please provide product amount!");
        return false;
    }

    if( document.addProduct.balanceOnTheFirstDayOfTheMonth.value == "" || !document.addProduct.balanceOnTheFirstDayOfTheMonth.value.match(/^\d+$/))
    {
        failNoty("Please provide product balanceOnTheFirstDayOfTheMonth!");
        return false;
    }

    if( document.addCigarette.receivedForMonth.value == "" || !document.addProduct.receivedForMonth.value.match(/^\d+$/))
    {
        failNoty("Please provide product receivedForMonth!");
        return false;
    }

    if( document.addProduct.soldForMonth.value == "" || !document.addProduct.soldForMonth.value.match(/^\d+$/))
    {
        failNoty("Please provide product soldForMonth!");
        return false;
    }

    return( true );
}

function volidateSearchByProductName(form) {
    if( form.searchByProductName.value == "")
    {
        failNoty("Please provide cigarette searchByProductName!");
        return false;
    }
    return(true);
}
