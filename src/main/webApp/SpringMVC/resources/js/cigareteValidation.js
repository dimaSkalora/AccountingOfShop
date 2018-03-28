function validateCigarette()
{
    if( document.addCigarette.goodsReceiptDate.value == "" )
    {
        failNoty( "Please provide cigarette goodsReceiptDate!" );
        return false;
    }

    if( document.addCigarette.category.value == "" )
    {
        failNoty( "Please provide cigarette category!" );
        return false;
    }

    if( document.addCigarette.productName.value == "" )
    {
        failNoty("Please provide cigarette productName!");
        /*document.addAlcohol.productName.focus() ;*/
        return false;
    }

    if( document.addCigarette.amount.value == "" || !document.addCigarette.amount.value.match(/^\d+$/))
    {
        failNoty("Please provide cigarette amount!");
        return false;
    }

    if( document.addCigarette.balanceOnTheFirstDayOfTheMonth.value == "" || !document.addCigarette.balanceOnTheFirstDayOfTheMonth.value.match(/^\d+$/))
    {
        failNoty("Please provide cigarette balanceOnTheFirstDayOfTheMonth!");
        return false;
    }

    if( document.addCigarette.receivedForMonth.value == "" || !document.addCigarette.receivedForMonth.value.match(/^\d+$/))
    {
        failNoty("Please provide cigarette receivedForMonth!");
        return false;
    }

    if( document.addCigarette.soldForMonth.value == "" || !document.addCigarette.soldForMonth.value.match(/^\d+$/))
    {
        failNoty("Please provide cigarette soldForMonth!");
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