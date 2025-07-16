-- Create ENUM type for challenge_type
DO $$ BEGIN
    CREATE TYPE challenge_type AS ENUM ('SELECT', 'ASSIST');
EXCEPTION
    WHEN duplicate_object THEN null;
END $$;

-- Create challenges table
CREATE TABLE IF NOT EXISTS challenges (
    challenge_id SERIAL PRIMARY KEY,
    challenge_question TEXT NOT NULL,
    challenge_type challenge_type NOT NULL,
    challenge_order INTEGER NOT NULL,
    lesson_id BIGINT NOT NULL,
    CONSTRAINT fk_lesson FOREIGN KEY (lesson_id) REFERENCES lessons(id) ON DELETE CASCADE
);

-- Create index for lesson_id
CREATE INDEX IF NOT EXISTS idx_challenge_lesson_id ON challenges (lesson_id);

-- Create challenge_options table
CREATE TABLE IF NOT EXISTS challenge_options (
    challenge_option_id SERIAL PRIMARY KEY,
    option_text TEXT NOT NULL,
    is_correct BOOLEAN NOT NULL,
    image_src TEXT,
    audio_src TEXT,
    challenge_id BIGINT NOT NULL,
    CONSTRAINT fk_challenge FOREIGN KEY (challenge_id) REFERENCES challenges(challenge_id) ON DELETE CASCADE
);

-- Create index for challenge_id
CREATE INDEX IF NOT EXISTS idx_option_challenge_id ON challenge_options (challenge_id);
