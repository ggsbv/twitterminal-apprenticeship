import com.codurance.twitterminal.Clock;
import com.codurance.twitterminal.TimestampFormatter;
import org.junit.Test;
import org.mockito.Mock;

import java.time.LocalDateTime;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TimestampFormatterShould {
    @Test
    public void
    format_a_date_as_relative_time_in_seconds() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nowMinusTenSeconds = now.minusSeconds(10);

        TimestampFormatter timestampFormatter = new TimestampFormatter();

        String timeAgo = timestampFormatter.formatTimeAgo(nowMinusTenSeconds);

        assertThat(timeAgo, is("10 seconds ago"));
    }

    @Test
    public void
    format_a_date_as_relative_time_when_only_one_second_behind() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nowMinusOneSecond = now.minusSeconds(1);

        TimestampFormatter timestampFormatter = new TimestampFormatter();

        String timeAgo = timestampFormatter.formatTimeAgo(nowMinusOneSecond);

        assertThat(timeAgo, is("1 second ago"));
    }

    @Test
    public void
    format_a_date_as_relative_time_in_minutes() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nowMinusTenMinutes = now.minusMinutes(10);

        TimestampFormatter timestampFormatter = new TimestampFormatter();

        String timeAgo = timestampFormatter.formatTimeAgo(nowMinusTenMinutes);

        assertThat(timeAgo, is("10 minutes ago"));
    }

    @Test
    public void
    format_a_date_as_relative_time_when_only_a_minute_ago() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nowMinusTenMinutes = now.minusMinutes(1);

        TimestampFormatter timestampFormatter = new TimestampFormatter();

        String timeAgo = timestampFormatter.formatTimeAgo(nowMinusTenMinutes);

        assertThat(timeAgo, is("1 minute ago"));
    }

    @Test
    public void
    format_a_date_as_relative_time_in_hours() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nowMinusTenMinutes = now.minusHours(16);

        TimestampFormatter timestampFormatter = new TimestampFormatter();

        String timeAgo = timestampFormatter.formatTimeAgo(nowMinusTenMinutes);

        assertThat(timeAgo, is("16 hours ago"));
    }

    @Test
    public void
    format_a_date_as_relative_time_when_only_one_hour_ago() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nowMinusOneHour = now.minusHours(1);

        TimestampFormatter timestampFormatter = new TimestampFormatter();

        String timeAgo = timestampFormatter.formatTimeAgo(nowMinusOneHour);

        assertThat(timeAgo, is("1 hour ago"));
    }

    @Test
    public void
    format_a_date_as_relative_time_in_days() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nowMinusTenDays = now.minusDays(10);

        TimestampFormatter timestampFormatter = new TimestampFormatter();

        String timeAgo = timestampFormatter.formatTimeAgo(nowMinusTenDays);

        assertThat(timeAgo, is("10 days ago"));
    }

    @Test
    public void
    format_a_date_as_relative_time_when_1_day_ago() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nowMinusTenDays = now.minusDays(1);

        TimestampFormatter timestampFormatter = new TimestampFormatter();

        String timeAgo = timestampFormatter.formatTimeAgo(nowMinusTenDays);

        assertThat(timeAgo, is("1 day ago"));
    }
}
