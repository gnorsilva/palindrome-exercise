Given we type a <string>
When we ask Palindromaton to verify it
Then we should be notified if it <isPalindrome>

Examples:
| string                        | isPalindrome |
| a                             |        false |  
| aa                            |        false |
| pop                           |         true |
| goncalo                       |        false |  
| Malayalam                     |         true |  
| Amma                          |         true |  
| Madam                         |         true |  
| Sator Arepo Tenet Opera Rotas |         true |
| Ten animals I slam in a net   |         true |
| Dammit_I'm_mad                |         true |
| 121                           |         true |
| 112211                        |         true |
| 11/22/11                      |         true |
| 1/10/11                       |         true |
| Sandro                        |        false |
| not a palindrome              |        false |
| 1/23/41                       |        false |
