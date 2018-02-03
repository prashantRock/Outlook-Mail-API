package com

class MailController {

    String accessToken = "EwA4A8l6BAAU7p9QDpi/D7xJLwsTgCg3TskyTaQAAUmpo/fZ3bEYMtKWzu8DwTGmMjbBQBINaDPFBQLDfTlCXJrBFydgOf5D4Q/mrP1THdyyDa207SQRRhvKfmapKjB8JSzbV8JFaJD7fF2SsJ3SIR3K0np7W/CkslKwanTtr5xmKmgkqA6E22Jc3zgvT0A5Rh11h0gxaAdSa9G8fiS7ZRA5YW0T1g0ph2pNK3lb4OBL2aNFaYCFjWwYh6eZfCL5XsFWbyigNkwCBYfwVxl83aa+Fzd8xvcBEjIxdUdiWGUlDx3An6U+LpdBtTUCAUkHBuJgmWH7XfmZDlQG1Hc7CFCIqgJSOGiaHQcJRPo/SQrqWYjiiNd4j0kMBuidv5cDZgAACJau9A26D74MCAJViEjykSXNJBNDsw6ngRBlWrmIH1SaeZg3hJuzp64Gc++cMweGTIoWYk/MlwlrBkvmzqMwBGtG4vuk5mkMbKrT0h02kWU3lGb/bLY6fSNtmhtDyIkukLmExiRFfcIn+muAsJPnwE1lsxKNmPtaeWqYHSjRAze4c69wFU4cuOkyhNtG0O9NY2eQIbAxJ/+ilfySeaWDMB7rkdBEUTHS3AfbSrtg5T4TZCcnY407nnTkFCuLev86+yP1T2FkIFrif08HEohVakplgzu9k/3tV8bomoNiv1ltYszx79StJ9zwXpuX3Pp1J4EQX2J+bJQf0+VyIpcJ1F5vJHzm4rpfkMSHk2JuuD8KH7v1EmDjSLRcH72oYngpU2AAeAUr/yOTDp3xp+TZd/3AIgQIqmA44v7yPOFUD8MC93iO3SYmAE0ohYjZYW5oXNBZU/5apo5yBe1uijJ0EIO7fQ1xOgGlyEW1jqqNSefjPVZqEaxBmf8h2qRbsZpw5/KZZ6iqbWNEy9smTvWT3myJbe+Pv9yyNGxa4GNobdoOAhJpdI4hp61kP7G64i9bDo0bYIOy90O4SODYDfVfqgk1dAym4pLVPdgpykMXkbsx5JE/9lGJKzUgDeZG0Tg2mX2QdNPH3oBXalqGzLRkLK3w2DcBkwBewVie1JobiYlMqi2BeHtaIVERQnsk/LClXgL3SAI="

    def index() {
        render (view: "/mail/index")
    }

    def fetchMessages() throws Exception{
        String completeURL = "https://graph.microsoft.com/v1.0/me/mailfolders/SentItems/messages"
        String response = CustomHttpRequest.sendGet(completeURL, accessToken)
        println response
        return response
    }

    def redirectURL (){
        println request.parameterMap.code
        String code = request.parameterMap.code
        return ""+code
    }

    def fetchAccessToken(){
        CustomHttpRequest.fetchAccessToken()
    }


}

