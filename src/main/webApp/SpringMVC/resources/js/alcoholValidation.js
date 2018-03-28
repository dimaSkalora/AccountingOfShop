function validate()
{
    if( document.addAlcohol.goodsReceiptDate.value == "" )
    {
        failNoty( "Please provide alcohol goodsReceiptDate!" );
        return false;
    }

    if( document.addAlcohol.category.value == "" )
    {
        failNoty( "Please provide alcohol category!" );
        return false;
    }

    if( document.addAlcohol.productName.value == "" )
    {
        failNoty("Please provide alcohol productName!");
        /*document.addAlcohol.productName.focus() ;*/
        return false;
    }

    if( document.addAlcohol.liter.value == "" )
    {
        failNoty("Please provide alcohol liter!");
        return false;
    }

    if( document.addAlcohol.balanceOnTheFirstDayOfTheMonth.value == "" )
    {
        failNoty("Please provide alcohol balanceOnTheFirstDayOfTheMonth!");
        return false;
    }

    if( document.addAlcohol.receivedForMonth.value == "" )
    {
        failNoty("Please provide alcohol receivedForMonth!");
        return false;
    }

    if( document.addAlcohol.soldForMonth.value == "")
    {
        failNoty("Please provide alcohol soldForMonth!");
        return false;
    }

    return( true );
}

function volidateSearchByProductName(form) {
    if( form.searchByProductName.value == "")
    {
        failNoty("Please provide alcohol searchByProductName!");
        return false;
    }
    return(true);
}