const ChatMessage = ({msg}) => {
    const {user, message} = msg
    const divClasses = user=="user" ? "rounded-lg p-2 m-2 bg-purple-300 text-white self-end" : "rounded-lg p-2 m-2 bg-white self-start"
    return (
        <div className={divClasses}>
            {message}
        </div>
    )
}

export default ChatMessage;
