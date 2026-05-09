const ChatResponse = ({ response }) => {
    if (!response) return null;

    return (
        <div className="container my-4">

            {/* AI Answer */}
            <h3>🤖 AI Response</h3>

            <div className="card mb-3">
                <div className="card-body">
                    <p>{response.data}</p>
                </div>
            </div>

            {/* Token section (only if you still return it from backend later) */}
            {response.usageMetadata && (
                <>
                    <h4>📊 Token Usage</h4>

                    <p>Prompt Tokens: {response.usageMetadata.promptTokenCount}</p>
                    <p>Response Tokens: {response.usageMetadata.candidatesTokenCount}</p>
                    <p>Total Tokens: {response.usageMetadata.totalTokenCount}</p>
                </>
            )}

        </div>
    );
};

export default ChatResponse;