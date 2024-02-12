# Domain Models, Class Diagrams and Test Plan

[1. User Stories and Tests](#user-stories-and-tests)
[2. Kanban](#kanban)
[3. AI Documentation](#AI-documentation)

# User Stories and Tests

## 1. As a user I want to be able to add a contact to my address book do that I can use that information to contact them

### Tests
1. Test 1: com.app.ContactManager adds contact to com.app.Contact
2. Test 2: Added contact information is correctly stored in the address book.
3. Test 3:Verify how the system behaves when trying to add a contact without any information.
4. Test 4: Verify how the system behaves when trying to add a contact with only partial information.

---

## 2. As a user I want to be able to search for a contact by name so that I can contact them

### Tests
1. Test 5: check that a contact can be searched by name.
2. Test 6: check that the correct contact is returned when searched by name.
3. Test 7: Verify how the system behaves when searching for a name that does not exist in the address book.
4. Test 8: Verify how the system behaves when searching for a name with special characters or numbers.

---

## 3. As a user I want to be able to see my search results so that I can check I am contacting the right person

### Tests
1. Test 9: search results are displayed to user.

---

## 4. As a user I want to be able to remove a contact from the address book as I am longer friends with them

### Tests
1. Test 10: Check a contact can be removed from the address book.
2. Test 11: Verify how the system behaves when trying to remove a contact that does not exist in the address book.

---

## 5. As a user I want to be able to edit a contacts details as they have changed address

### Tests
1. Test 12: Edited details are correctly updated in the address book.
2. Test 13:  Verify how the system behaves when trying to edit a contact that does not exist in the address book.
3. Test 14: Verify how the system behaves when trying to edit a contact with invalid or incomplete information.

---

## 6. As a user I do not want to have duplicate phone numbers and address so that can ensure each contact is uniquw and avoids confusion when searching/updating contact information

### Tests
1. Test 15: check that the system does not allow duplicate phone numbers for a contact.
2. Test 16: Check that the system does not allow duplicate addresses for a contact.

---

## 7. As a user I want to be able to view all my contacts in the address book so that I can see how many people I know

### Tests
1. Test 17: all contacts in the address book can be viewed.
2. Test 18: correct number of contacts is displayed when viewing all contacts.
3. Test 19: Verify that the system behaves as expected when there are no contacts in the address book.
4. Test 20: Verify that the system can handle and correctly display a large number of contacts.

---

## 8. As a user I want to have an interface so that it is easier to use my address book
Note that the tests for use interface were not initiated other than Test 21.

### Tests
1. Test 21:  check that add is accessible through the interface.
2. check that search is accessible through the interface.
3. check that edit is accessible through the interface.
4. check that delete contacts is accessible through the interface.
5. Test 22: Adding a contact to the address book.
6. Test 23: Removing contact by name through address book class.
7. Test 24: Getting all contacts through address book class.



---

## 9. AF - As a user I want to be able to search for a contact by phone number and have the results displayed so that I can see who’s number keeps calling

### Tests
1. a contact can be searched by phone number.
2. the correct contact is returned when searched by phone number.
3. Verify that the system behaves as expected when searching for a phone number that does not exist in the address book.
4. Verify that the system can handle and correctly return results for a phone number search with multiple matches.

---

## 10. AF As a user I want to be able to search for a contact by email address and have the results display so that I can see who is emailing me

### Tests
1. a contact can be searched by email address.
2. the correct contact is returned when searched by email address.
3. Verify that the system behaves as expected when searching for an email address that does not exist in the address book.
4. Verify that the system can handle and correctly return results for an email address search with multiple matches.
---

## 11. AF As a user I want to be able to search for a contact by name, number, email address and have them displayed in alphabetical order so it is easier to find what I am looking for

### Tests
1.  a contact can be searched by name, number, and email address.
2.  the search results are displayed in alphabetical order.
---

## 12. AF As a user I want to be able to delete all contacts at once and confirm I am doing this so that I can live my life as a hermit but still not accidentally delete everything If I don’t want too

### Tests
1.  all contacts can be deleted at once.
2.  a confirmation prompt is displayed before deleting all contacts.

# Kanban

![Kanban](docs/kanbanChall3.jpg)

# AI Documentation

## AI used to generate edge and corner cases

![Edge AI](docs/test_edge_case.png)
