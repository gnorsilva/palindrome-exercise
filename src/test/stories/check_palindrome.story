Given we run the palindrome application
When we ask if a <string> is a palindrome
Then application should display <isPalindrome>

Examples:
| string                        | isPalindrome |
| a                             |        false |  
| pop                           |         true |  
| goncalo                       |        false |  
| Malayalam                     |         true |  
| Amma                          |         true |  
| Madam                         |         true |  
| Dammit I'm mad                |         true |  
| Sator Arepo Tenet Opera Rotas |         true |
| 11/11/11                      |         true |
| 11/22/11                      |         true |
| 1/10/11                       |         true |
| Sandro                        |        false |
| not a palindrome              |        false |
| 1/23/41                       |        false |
| 112211                        |         true |
