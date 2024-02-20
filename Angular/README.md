Project Structure:
The project is an Angular-based application that manages user profiles and messaging.

Main Components:
Profile: Displays and allows editing of user profile details.
Chat: Manages conversations between users.

Services:
ProfileService: Responsible for handling user profile creation, updating, and deletion operations.
ChatService: Manages retrieval and sending of messages between users.
AuthService: Authenticates and manages user access.

Modules:
SharedModule: Encapsulates shared components and modules used in multiple parts of the application.
ProfileModule: Manages user profile functionality.
ChatModule: Handles messaging between users.

Routing:
AppRoutingModule: Defines the main paths of the application and lazy loading of modules.

Additional Components:
UsersSearchComponent: User search field.
UsersListComponent: List of users with interactive actions.
ChatInputComponent: Component for sending messages in a chat.
ChatWindowComponent: Displays chat messages and allows sending.

Styling:
Sass is used for managing component design and styling.

The project leverages a significant implementation of a custom directive called statusIndicator. This directive is used to display the connection status of a user (online/offline), assigning dynamic colors and text based on a boolean passed.
